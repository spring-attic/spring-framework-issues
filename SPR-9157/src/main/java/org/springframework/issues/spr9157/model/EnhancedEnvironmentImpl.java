package org.springframework.issues.spr9157.model;

/**
 * Enhanced environment implementation.
 * 
 * @author ferengra
 */
public class EnhancedEnvironmentImpl extends EnvironmentImpl implements EnhancedEnvironment {
    private String description;

    @SuppressWarnings("unused")
    private EnhancedEnvironmentImpl() {
        // Hibernate
    }

    public EnhancedEnvironmentImpl(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
