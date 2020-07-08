package basic.mytry.proj5WithConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("basic.mytry.proj5WithConfig.config")
@SpringBootApplication
public class Proj5App {
    public static void main(String[] args) {
        SpringApplication.run(Proj5App.class, args);
        // System.out.println(SomeBean.nameStr);
    } 
}