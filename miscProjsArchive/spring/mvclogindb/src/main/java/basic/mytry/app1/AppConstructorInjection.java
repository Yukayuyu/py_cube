package basic.mytry.app1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import basic.mytry.proj4Drawing.Triangle;


public class AppConstructorInjection {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "mvclogindb/src/main/java/basic/mytry/app1/VehicleBean.xml");
        VehicleImpl vehicle = (VehicleImpl) context.getBean("vehicle");
        vehicle.drive();
    } 
}