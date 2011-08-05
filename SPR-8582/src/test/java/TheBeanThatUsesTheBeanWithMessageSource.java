/**
 * This is any bean that makes use of a bean defined in another context.
 *
 * @author Kai Hackemesser.
 */
public class TheBeanThatUsesTheBeanWithMessageSource {

	private TheBeanWithMessageSource bean;

	public void setBean(TheBeanWithMessageSource bean) {
		this.bean = bean;
	}

	@Override
	public String toString() {
		return "TheBeanThatUsesTheBeanWithMessageSource > " + bean;
	}
}
