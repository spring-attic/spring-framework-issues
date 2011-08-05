import org.springframework.context.MessageSource;

/**
 * This is a bean with messageSource dependency.
 *
 * @author Kai Hackemesser.
 */
public class TheBeanWithMessageSource {

	private MessageSource messageSource;

	@Override
	public String toString() {
		return "TheBeanWithMessageSource > " + messageSource.toString();
	}

	/**
	 * @param messageSource the new value for the messageSource property.
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
