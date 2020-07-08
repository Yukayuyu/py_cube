package nonexml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration
// @AutoConfigurationPackage
// @ComponentScan("nonexml.config")
@SpringBootApplication
public class App6 {
    public static void main(String[] args) {
        SpringApplication.run(App6.class, args);
    
    }
}