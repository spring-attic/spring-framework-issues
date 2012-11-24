import java.util.Date;

public final class Three extends Two {

    private final Boolean c1;

    public Three() {
        this(null, null, null, null, null, null, null, null);
    }

    public Three(Date a1, Boolean b1, Boolean b2, Boolean b3, Boolean b4, Boolean b5, String b6, Boolean c1) {
        super(a1, b1, b2, b3, b4, b5, b6);
        this.c1 = c1;
    }

    public Boolean getC1() {
        return c1;
    }

}
