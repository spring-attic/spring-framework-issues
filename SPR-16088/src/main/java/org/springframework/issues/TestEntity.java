package org.springframework.issues;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Greg Potter
 * @since 10/17/17
 */
@Entity
@Table(name = "test")
public class TestEntity {

    @Id
    @Column(name = "id")
    private int id;

    public TestEntity() {
    }

    public TestEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
