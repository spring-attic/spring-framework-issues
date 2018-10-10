package org.springframework.issues;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by marten on 30-06-17.
 */
public class DisposableBeanCreatingFactoryBean implements FactoryBean<DisposableBean> {
    @Override
    public DisposableBean getObject() throws Exception {
        return new DisposableBean();
    }

    @Override
    public Class<?> getObjectType() {
        return DisposableBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
