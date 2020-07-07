package basic.mytry.app1Annotation;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
    public void drive() {
        System.out.println("bike drive");
    }
}