package nonexml;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("nonexml.config")
public class App6 {
    public static void main(String[] args) {
        SpringApplication.run(App6.class, args);
    
}