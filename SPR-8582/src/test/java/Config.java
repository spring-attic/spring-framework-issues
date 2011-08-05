import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * This is the main context config class that imports older xml configurations. It creates
 * the messageSource and a bean depending on an xml defined bean that uses the
 * messageSource. This class does the same as the applicationcontext.xml file.
 */
@Configuration
@ImportResource("inherited.xml")
public class Config {

	@Autowired
	private TheBeanWithMessageSource theBeanWithMessageSource;

	@Bean
	public MessageSource messageSource() {
		return new ResourceBundleMessageSource();
	}

	@Bean
	public TheBeanThatUsesTheBeanWithMessageSource theOtherBean() {
		TheBeanThatUsesTheBeanWithMessageSource theOtherBean =
				new TheBeanThatUsesTheBeanWithMessageSource();
		theOtherBean.setBean(theBeanWithMessageSource);
		return theOtherBean;
	}

}
