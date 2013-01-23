package org.springframework.issues;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(useDefaultFilters = true, excludeFilters = { @Filter(Controller.class),
	@Filter(type = FilterType.ASSIGNABLE_TYPE, value = DispatcherConfig.class) })
public class ApplicationConfig {

}
