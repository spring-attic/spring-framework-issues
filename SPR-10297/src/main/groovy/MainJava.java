import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainJava {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("beans.xml");
    }
}
