package basic.mytry.app1Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * class name might me a "Person" who owns a particular type of vehicle
 */
@Configuration
public class VehicleImpl {

    @Autowired
    public Vehicle vehicle;
    // @Qualifier("vehicle")
    // @Autowired
    // public VehicleImpl(Car vehicle) {
    // SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    // VehicleImpl.vehicle = vehicle;
    // }


}