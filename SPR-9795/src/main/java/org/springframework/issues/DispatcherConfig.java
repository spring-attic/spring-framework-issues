
package org.springframework.issues;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(
		basePackages = "org.springframework.issues.sub",
		useDefaultFilters = false,
		includeFilters = { @Filter(Controller.class) })
public class DispatcherConfig {
}
