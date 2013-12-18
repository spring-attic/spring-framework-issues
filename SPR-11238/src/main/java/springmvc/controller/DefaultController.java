package springmvc.controller;

import springmvc.context.BooleanPropertyEditor;
import springmvc.context.DatePropertyEditor;
import springmvc.context.OpenIdUserInfo;
import springmvc.model.Member;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.mobile.device.Device;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springdao.DaoManager;
import springdao.RepositoryManager;
import springdao.support.DaoPropertyEditor;

/**
 *
 * @author Kent Yeh
 */
@Controller
public class DefaultController {

    private static Logger logger = LogManager.getLogger(DefaultController.class);
    @DaoManager
    private RepositoryManager<Member> memberManager;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DatePropertyEditor());
        binder.registerCustomEditor(Date.class, new BooleanPropertyEditor());
        binder.registerCustomEditor(Member.class, new DaoPropertyEditor(memberManager));
    }

    @RequestMapping("/")
    public Callable<String> root(final Device device, final Model model) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (device.isMobile()) {
                    logger.debug("Connect devcie is mobile");
                    model.addAttribute("device", "mobile");
                    //return "mobileIndex";
                } else if (device.isTablet()) {
                    logger.debug("Connect devcie is tablet");
                    model.addAttribute("device", "tablet");
                    //return "tabletIndex";
                } else {
                    model.addAttribute("device", "normal");
                    logger.debug("Connect device is normal device.");
                }
                return "index";
            }
        };
    }

    private String getPrincipalId(Principal principal) {
        Object p = principal instanceof OpenIDAuthenticationToken ? ((OpenIDAuthenticationToken) principal).getPrincipal() : principal;
        return p instanceof OpenIdUserInfo ? ((OpenIdUserInfo) p).getId() : principal.getName();
    }

    /**
     * Response all users' data as json.
     *
     * @return
     */
    @RequestMapping(value = "/admin/users", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Callable<String> listuser() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                List<Member> users = memberManager.findByCriteria("WHERE enabled=?1 ORDER BY name", "Y");
                if (users == null || users.isEmpty()) {
                    return "{\"total\":0,\"users\":[]}";
                } else {
                    StringBuilder sb = new StringBuilder("{\"total\":").append(users.size()).append(",\"users\":[");
                    boolean isFirst = true;
                    for (Member user : users) {
                        if (!isFirst) {
                            sb.append(",");
                        }
                        sb.append("{\"account\":\"").append(user.getId()).append("\",\"name\":\"").append(user.getName())
                                .append("\",\"birthday\":\"").append(String.format("%tF", user.getBirthDay())).append("\"}");
                        isFirst = false;
                    }
                    sb.append("]}");
                    return sb.toString();
                }
            }
        };
    }

    /**
     * display current user's info.
     *
     * @param request
     * @param principal
     * @return
     */
    @RequestMapping("/user/myinfo")
    public Callable<String> myinfo(final HttpServletRequest request, final Principal principal) {

        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                request.setAttribute("member", memberManager.findByPrimaryKey(getPrincipalId(principal)));
                return "index";
            }
        };
    }

    /**
     * Only adminstrator could display any user's info.
     *
     * @param account
     * @param request
     * @return
     */
    @RequestMapping("/admin/user/{account}")
    public Callable<String> userinfo(final @PathVariable Member account, final HttpServletRequest request) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (account != null) {
                    request.setAttribute("member", account);
                }
                return "index";
            }
        };
    }
}