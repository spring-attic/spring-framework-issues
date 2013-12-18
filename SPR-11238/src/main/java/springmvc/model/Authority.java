package springmvc.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Kent Yeh
 */
@Entity
@Table(name = "authorities")
public class Authority implements Serializable {

    private static final long serialVersionUID = -7454760999684175357L;
    @Id
    @NotNull
    @SequenceGenerator(name = "authoritySeq", sequenceName = "authorities_aid_seq")
    @GeneratedValue(generator = "authoritySeq", strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private int id = -1;
    private String authority;
    @ManyToOne
    @JoinColumn(name = "account", referencedColumnName = "account")
    private Member member;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Authority other = (Authority) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
