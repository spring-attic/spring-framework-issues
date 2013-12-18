package springmvc.context;

import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Kent Yeh
 */
public class OpenIdUserInfo extends User {

    private static final long serialVersionUID = -2209416924912982094L;
    private String id;
    private String name;

    public OpenIdUserInfo(String id, String name, String roles) {
        super(id, "unused", true, true, true, true, roles == null || roles.isEmpty()
                ? new ArrayList<GrantedAuthority>(0) : AuthorityUtils.commaSeparatedStringToAuthorityList(roles));
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final OpenIdUserInfo other = (OpenIdUserInfo) obj;
        return this.id == null ? other.id == null : this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
