package com.vodori.jpa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
public class ConcreteChild extends AbstractParent {
    @Basic
    @Column(name = "CHILD_DATA_1")
    private String childData1;
    @Basic
    @Column(name = "CHILD_DATA_2")
    private String childData2;

    //~--- get methods --------------------------------------------------------

    public String getChildData1() {
        return childData1;
    }

    public String getChildData2() {
        return childData2;
    }

    //~--- set methods --------------------------------------------------------

    public void setChildData1(String childData1) {
        this.childData1 = childData1;
    }

    public void setChildData2(String childData2) {
        this.childData2 = childData2;
    }
}
