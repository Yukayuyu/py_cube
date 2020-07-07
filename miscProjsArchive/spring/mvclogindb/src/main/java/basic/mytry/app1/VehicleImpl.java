package basic.mytry.app1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@Component
public class VehicleImpl implements Vehicle{
    private static Car vehicle;
    // @Qualifier("vehicle")
    public VehicleImpl(Car vehicle) {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        VehicleImpl.vehicle = vehicle;
    }

    @Override
    public void drive() {
        this.vehicle.drive();
    } 
}