package nonexml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("nonexml.config")
// @SpringBootApplication
@EnableAutoConfiguration
public class App6 {
    public static void main(String[] args) {
        SpringApplication.run(new Class[] {App6.class, ConfigurationServiceApplication.class}, args);
    }
}
