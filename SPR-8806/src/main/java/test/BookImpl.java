package test;

/**
 * Created by IntelliJ IDEA.
 * User: nardonep
 * Date: 27/10/11
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */
public class BookImpl implements Book {
    private String name;

    public BookImpl() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
