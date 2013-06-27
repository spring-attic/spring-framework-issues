package org.springframework.issues;

import java.io.*;
import java.util.*;

public class SoftwareVendorVO implements Serializable {

    private int id;
    private String name;
    private List<SoftwareNameVO> software = new ArrayList<SoftwareNameVO>();
    private SoftwareNameVO newSoftwareNameToAdd = new SoftwareNameVO();

    public SoftwareVendorVO() {
    }

    public SoftwareVendorVO(int id) {
        this.id = id;
    }

    public SoftwareVendorVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SoftwareNameVO> getSoftware() {
        return software;
    }

    public void setSoftware(List<SoftwareNameVO> software) {
        this.software = software;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SoftwareNameVO getNewSoftwareNameToAdd() {
        return newSoftwareNameToAdd;
    }

    public void setNewSoftwareNameToAdd(SoftwareNameVO newSoftwareNameToAdd) {
        this.newSoftwareNameToAdd = newSoftwareNameToAdd;
    }
}
