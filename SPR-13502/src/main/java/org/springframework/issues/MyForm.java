package org.springframework.issues;

import java.util.Set;

public class MyForm {

    private String name;

    private Set<SpringProjects> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SpringProjects> getProjects() {
        return projects;
    }

    public void setProjects(Set<SpringProjects> projects) {
        this.projects = projects;
    }
}
