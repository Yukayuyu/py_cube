package basic.wth;

import org.springframework.beans.factory.annotation.Autowired;



public class Person {

    @Autowired
    private Car car;

    public Car getCar() {
        return car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                '}';
    }
}
