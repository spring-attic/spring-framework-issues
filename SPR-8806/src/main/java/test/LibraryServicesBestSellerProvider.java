package test;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 30/10/11
 * Time: 17:24
 * To change this template use File | Settings | File Templates.
 */
public interface LibraryServicesBestSellerProvider extends BestSellerProvider {

    @Override
    LibraryServicesBook getBestSeller();
}
