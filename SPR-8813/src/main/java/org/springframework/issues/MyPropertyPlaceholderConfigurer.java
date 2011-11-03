package org.springframework.issues;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    protected void processProperties( ConfigurableListableBeanFactory beanFactory, Properties props ) throws BeansException{
        logger.debug( "processProperties" );
        super.processProperties( beanFactory, props );

        this.beanFactory = beanFactory;
    }

    public void reload(){
        logger.info( "reloading properties" );


        String[] beanNames = beanFactory.getBeanDefinitionNames();
        for( String curName : beanNames ){
            try{
                BeanDefinition bd = beanFactory.getMergedBeanDefinition( curName );
                if( bd.isAbstract() || !bd.isSingleton() ){
                    continue;
                }

                Object bean = beanFactory.getBean( curName );

                // only change @Value properties
                // XXX does not work with methods and cglib
                beanFactory.autowireBeanProperties( bean, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false );

            }
            catch( Exception ex ){
                logger.warn( "reload error for bean " + curName, ex );
            }
        }

    }


}
