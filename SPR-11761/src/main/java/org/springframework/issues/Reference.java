package org.springframework.issues;

public final class Reference<T> {

    public static <X> Reference<X> create(final X referred) {
        return new Reference<X>(referred);
    }
    
    private T referred;
    
    public Reference() { }
        
    public Reference(final T referred) {
        this.referred = referred;
    }

    public T get() {
        return referred;
    }
    
    public void set(final T referred) {
        this.referred = referred;
    }

    @Override
    public int hashCode() {
        return referred == null ? 0 : referred.hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (o == null) {
            return false;
        } else if (!(o instanceof Reference)) {
            return false;
        } else {
            return referred.equals(referred);
        }
    }
    
    @Override
    public String toString() {
        return "Reference to [" + referred + "]";
    }
    
}
