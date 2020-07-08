package basic.mytry.proj5WithConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeBean {

    @Value("${namestr}")
    public static String nameStr;
    
}