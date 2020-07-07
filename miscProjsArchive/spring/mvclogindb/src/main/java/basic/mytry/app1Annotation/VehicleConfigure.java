package basic.mytry.app1Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("basic.mytry.app1Annotation")
public class VehicleConfigure {

    @Bean
    public Vehicle vehicle(){
        return new Bike();
    }

    @Bean(name="impl")
    public VehicleImpl vehicleImpl(){
        return new VehicleImpl();
    } 
}