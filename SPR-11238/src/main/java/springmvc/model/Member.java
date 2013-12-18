package springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kent Yeh
 */
@Entity
@Table(name = "appmember")
public class Member implements Serializable {
    
    private static final long serialVersionUID = 395368712192880218L;
    @Id
    @NotNull
    @Column(name = "account")
    private String id;
    @NotNull(message = "user's name not allow null")
    private String name;
    private String enabled = "Y";
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDay;
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private Set<Authority> authorities;
    
    public Member() {
    }
    
    public Member(String id, String name) {
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
    
    public boolean isEnabled() {
        return "Y".equals(enabled);
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled ? "Y" : "N";
    }
    
    public Date getBirthDay() {
        return birthDay == null ? null : new Date(birthDay.getTime());
    }
    
    public void setBirthDay(Date birthDay) {
        if (birthDay == null){
            this.birthDay = null;
        }else if (this.birthDay == null) {
            this.birthDay = new Date(birthDay.getTime());
        } else {
            this.birthDay.setTime(birthDay.getTime());
        }
    }
    
    public Set<Authority> getAuthorities() {
        return authorities;
    }
    
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Member other = (Member) obj;
        return this.id == null ? other.id == null : this.id.equals(other.id);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
        return String.format("%s[%s]", name, id);
    }
}
