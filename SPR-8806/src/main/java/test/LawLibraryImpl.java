package test;

/**
 * Created by IntelliJ IDEA.
 * User: nardonep
 * Date: 27/10/11
 * Time: 15:09
 * To change this template use File | Settings | File Templates.
 */
public class LawLibraryImpl extends LibraryImpl implements LawLibrary,LibraryServicesManipulator,
        LawLibraryServices,LawLibraryServicesManipulator {


    public LawLibraryImpl() {
        super();
    }

    @Override
    public LawBook getBestSeller() {
        return (LawBook) super.getBestSeller();
    }




}
