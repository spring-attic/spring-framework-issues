package it.nibbles.test.objs;

import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserTest")
public class User {

    public static final int STR_LEN = 64;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", nullable = false)
    private String name;

    public User() {
        setId(new Random().nextInt());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
