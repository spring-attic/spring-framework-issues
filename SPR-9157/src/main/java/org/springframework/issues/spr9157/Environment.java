package org.springframework.issues.spr9157;

/**
 * Environment.
 */
public class Environment {
    private Long id;
    private String name;

    @SuppressWarnings("unused")
    private Environment() {
        // Hibernate
    }

    public Environment(String name) {
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
        if (!(obj instanceof Environment)) {
            return false;
        }
        Environment other = (Environment) obj;
        return getName().equals(other.getName());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Environment [id=").append(id).append(", name=").append(name).append("]");
        return builder.toString();
    }
}
