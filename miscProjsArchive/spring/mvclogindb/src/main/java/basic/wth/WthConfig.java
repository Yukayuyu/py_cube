package basic.wth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("basic.wth")
public class WthConfig {
    @Bean
    public Car car(){
        return new FengTian();
    }
    @Bean
    public Person person(){
        return new Person();
    }
}
