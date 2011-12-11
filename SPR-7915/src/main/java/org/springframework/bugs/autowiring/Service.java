package org.springframework.bugs.autowiring;

import org.springframework.beans.factory.annotation.Autowired;

public class Service {
    @Autowired
    private Candidate dependency;

    public void setDependency(Candidate dependency) {
        this.dependency = dependency;
    }

    public Candidate getDependency() {
        return dependency;
    }
}
