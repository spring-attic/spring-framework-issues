package org.springframework.issues.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

public class HibernateLoadTimeWeaverAwareProcessor implements BeanPostProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateLoadTimeWeaverAwareProcessor.class);

	private final LoadTimeWeaver loadTimeWeaver;

	public HibernateLoadTimeWeaverAwareProcessor(LoadTimeWeaver loadTimeWeaver) {
		this.loadTimeWeaver = new HibernateClassBypassingLoadTimeWeaver(loadTimeWeaver);
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof LoadTimeWeaverAware && bean instanceof EntityManagerFactoryInfo) {
			JpaDialect jpaDialect = ((EntityManagerFactoryInfo) bean).getJpaDialect();
			boolean isHibernate = jpaDialect instanceof HibernateJpaDialect;
			LOGGER.info("EMF {} has Hibernate dialect: {}", bean, isHibernate);
			if (isHibernate) {
				LOGGER.info("Injecting custom LTW: {}", loadTimeWeaver);
				((LoadTimeWeaverAware) bean).setLoadTimeWeaver(loadTimeWeaver);
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}