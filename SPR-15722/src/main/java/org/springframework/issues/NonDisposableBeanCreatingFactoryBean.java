package org.springframework.issues;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by marten on 30-06-17.
 */
public class NonDisposableBeanCreatingFactoryBean implements FactoryBean<NonDisposableBean> {
    @Override
    public NonDisposableBean getObject() throws Exception {
        return new NonDisposableBean();
    }

    @Override
    public Class<?> getObjectType() {
        return NonDisposableBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }


}
