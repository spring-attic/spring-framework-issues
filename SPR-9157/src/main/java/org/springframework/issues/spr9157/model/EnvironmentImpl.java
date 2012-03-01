package org.springframework.issues.spr9157.model;

/**
 * Environment implementation.
 * 
 * @author ferengra
 */
public class EnvironmentImpl implements Environment {
    private Long id;
    private String name;

    protected EnvironmentImpl() {
        // Hibernate
    }

    public EnvironmentImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnhancedEnvironmentImpl)) {
            return false;
        }
        EnhancedEnvironmentImpl other = (EnhancedEnvironmentImpl) obj;
        return getName().equals(other.getName());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("EnvironmentImpl [id=").append(id).append(", name=").append(name).append("]");
        return builder.toString();
    }
}
