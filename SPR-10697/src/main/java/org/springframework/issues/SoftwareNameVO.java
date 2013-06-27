package org.springframework.issues;

import java.io.*;
import java.util.*;

public class SoftwareNameVO implements Serializable {

    private int id;
    private boolean someBoolean;
    private String name;
    private List<SoftwareVersionVO> versions = new ArrayList<SoftwareVersionVO>();

    public SoftwareNameVO() {
    }
    
    public SoftwareNameVO(int id, boolean someBoolean) {
        this.id = id;
        this.someBoolean = someBoolean;
    }

    public SoftwareNameVO(int id, String name) {
        this();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public void setSomeBoolean(boolean someBoolean) {
        this.someBoolean = someBoolean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SoftwareVersionVO> getVersions() {
        return versions;
    }

    public void setVersions(List<SoftwareVersionVO> versions) {
        this.versions = versions;
    }
}
