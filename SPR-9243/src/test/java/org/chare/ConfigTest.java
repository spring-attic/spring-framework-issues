package org.chare;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.chare.service.Service;
import org.junit.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class ConfigTest {

	@Test
	public void testConfig() throws Exception {
		AbstractApplicationContext context = createContext(Config.class, DependencyConfig.class);
		assertNotNull(context.getBean(Service.class));
		context.close();
	}

	@Configuration
	static class DependencyConfig {

	}


	public static AnnotationConfigWebApplicationContext createContext(final Class<?> ... configClasses) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext() {
			@Override
			public String[] getConfigLocations() {
				return convertToConfigLocations(configClasses);
			}
		};
		context.refresh();
		return context;
	}

	public static String[] convertToConfigLocations(Class<?>... configClasses) {
		List<String> names = new ArrayList<String>();
		for (Class<?> configClass : configClasses)
			names.add(configClass.getName());
		return names.toArray(new String [] {});
	}
}
