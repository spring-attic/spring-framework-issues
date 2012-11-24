import java.util.Date;

public abstract class One {

    private final Date a1;

    public One() {
        this(null);
    }

    protected One(Date a1) {
        this.a1 = a1;
    }

    public Date getA() {
        return a1;
    }

}
