package springmvc.context;

import springmvc.model.Authority;
import springmvc.model.Member;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;
import springdao.DaoManager;
import springdao.RepositoryManager;

/**
 * Only for OpenId useage.(提供給OpenId使用)
 *
 * @author Kent Yeh
 */
@Service("openIdUserService")
public class OpenIdUserService implements UserDetailsService, AuthenticationUserDetailsService<OpenIDAuthenticationToken> {

    private static Logger logger = LogManager.getLogger(OpenIdUserService.class);
    @DaoManager
    private RepositoryManager<Member> memberManager;

    /**
     * Deprecated from 3.1<br/>
     * 3.1以後OpenId不叫用這個函式
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String fullname = username;
        //format may be account:name called by loadUserDetails,格式可能為 "帳號:姓名",由loadUserDetails函式叫用
        int idx = username.indexOf(':');
        if (idx > -1) {
            fullname = username.substring(idx + 1);
            username = username.substring(0, idx);
        }
        //Find user data,找到用戶資料
        Member user = memberManager.findByPrimaryKey(username);
       //Decide user's roles,自行決定如何給角色
        StringBuilder roles = null;
        for (Authority authority : user.getAuthorities()) {
            if (roles == null) {
                roles = new StringBuilder(authority.getAuthority());
            } else {
                roles.append(",").append(authority.getAuthority());
            }
        }
        if (roles == null) {
            return new OpenIdUserInfo(username, fullname,"");
        } else {
            return new OpenIdUserInfo(username, fullname, roles.toString());
        }
    }

    /**
     * 3.1以後OpenId真正叫用這個函式
     */
    @Override
    public UserDetails loadUserDetails(OpenIDAuthenticationToken token) throws UsernameNotFoundException {
        String userid = null, fullname = null;
        List<OpenIDAttribute> attributes = token.getAttributes();
        for (OpenIDAttribute attribute : attributes) {
            if (attribute.getName().equals("nickname")) {
                userid = attribute.getValues().get(0);
            } else if (attribute.getName().equals("fullname")) {
                fullname = attribute.getValues().get(0);
            }
            if (userid != null && fullname != null) {
                break;
            }
        }
        if (userid == null) {
            throw new UsernameNotFoundException(String.format("授權中心並無用戶[%s]的資料", fullname));
        } else {
            UserDetails userInfo = loadUserByUsername(userid + ":" + fullname);
            if (userInfo.getAuthorities().isEmpty()) {
                throw new UsernameNotFoundException(String.format("用戶[%s]尚未取得使用權限，請聯絡管理人員", fullname));
            } else {
                logger.debug("取得用戶[{}]角色:{}", userid, userInfo.getAuthorities());
                return userInfo;
            }
        }
    }
}