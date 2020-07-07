package basic.wth;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class CarTest {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(WthConfig.class);
        Person person = (Person) context.getBean("person");
        person.getCar().driver();
    }
}
