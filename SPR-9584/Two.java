import java.util.Date;

public abstract class Two extends One {

    private final Boolean b1;
    private final Boolean b2;
    private final Boolean b3;
    private final Boolean b4;
    private final Boolean b5;
    private final String b6;

    protected Two(Date a1, Boolean b1, Boolean b2, Boolean b3, Boolean b4, Boolean b5, String b6) {
        super(a1);
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.b6 = b6;
    }

    public Boolean getB1() {
        return b1;
    }

    public Boolean getB2() {
        return b2;
    }

    public Boolean getB3() {
        return b3;
    }

    public Boolean getB4() {
        return b4;
    }

    public Boolean getB5() {
        return b5;
    }

    public String getB6() {
        return b6;
    }
}
