package org.chare;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy
@Import({
	org.chare.service.Config.class,
	org.chare.otherService.Config.class
})
public class Config {

}
