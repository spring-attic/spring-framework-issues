package spring.config;

/**
 * @author jbaruch
 * @since 10/10/12
 */
public class MyBeanImpl implements MyBean {

    private boolean methodCalled;

    @Override
    public void methodToCall(){
        methodCalled = true;
    }

    @Override
    public boolean isMethodCalled() {
        return methodCalled;
    }
}
