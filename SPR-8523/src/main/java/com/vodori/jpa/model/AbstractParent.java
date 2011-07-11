package com.vodori.jpa.model;

import javax.persistence.*;

/**
 *
 *
 *
 *
 */
@Entity
@Table(name = "ABSTRACT_PARENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class AbstractParent {
    @Basic
    @Column(name = "DATA_POINT_1_PARENT")
    private String dataPoint1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private String id;

    //~--- get methods --------------------------------------------------------

    public String getDataPoint1() {
        return dataPoint1;
    }

    public String getId() {
        return id;
    }

    //~--- set methods --------------------------------------------------------

    public void setDataPoint1(String dataPoint1) {
        this.dataPoint1 = dataPoint1;
    }

    public void setId(String id) {
        this.id = id;
    }
}
