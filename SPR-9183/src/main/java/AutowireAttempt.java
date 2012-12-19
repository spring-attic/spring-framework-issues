import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireAttempt {
  private String field;

  @Value("autowired")
  public void setField(String value) {
    this.field = value;
  }

  public static void main(String[] args) {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context.xml");
    //    System.out.println(String.format("Field value for bean created before override is [%s]", ((AutowireAttempt)ctx.getBean("before_overriding")).field));
    System.out.println(String.format("Field value for overriding bean is [%s], expected [overridden]", ((AutowireAttempt)ctx.getBean("overriding")).field));
    System.out.println(String.format("Field value for bean created after override is [%s], expected [autowired]", ((AutowireAttempt)ctx.getBean("after_overriding")).field));
  }
}
