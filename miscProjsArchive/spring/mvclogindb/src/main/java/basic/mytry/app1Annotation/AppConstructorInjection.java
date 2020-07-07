package basic.mytry.app1Annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppConstructorInjection {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(
VehicleConfigure.class);
        VehicleImpl vehicleImpl = (VehicleImpl) context.getBean("impl");
        vehicleImpl.vehicle.drive();
    }
}