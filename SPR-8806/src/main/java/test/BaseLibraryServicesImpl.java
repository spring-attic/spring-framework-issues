package test;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 30/10/11
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
public  class BaseLibraryServicesImpl implements LibraryServicesManipulator {

    private String name;

    public BaseLibraryServicesImpl() {
        super();
    }

    private Book bestSeller;

    @Override
    public Book getBestSeller(){
        return bestSeller;
    }

    public void setBestSeller(Book bestSeller) {
        this.bestSeller = bestSeller;
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
