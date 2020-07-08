import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.stereotype.Component;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Proj5WebAppInitializerOnCp implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        // This is a call back method, which means that:
        // The implement of ServletContext is given by per web server render, e.g. Tomcat.
        // One webapp has only one ServletContext instance, created by the server render.
        // Programmer use the methods in the servletContext in the input to communicate with the Server.
        // This is the web.xml replacment--Things needs to be done here:---------------
        // 1. Create a dispatcher servlet
        // 2. Register the dispatcher servlet with the method provided by the servletContext
        System.out.println("loadedoncp");
        AnnotationConfigWebApplicationContext context
          = new AnnotationConfigWebApplicationContext();
          context.register();
 
        servletContext.addListener(new ContextLoaderListener(context));
 
        ServletRegistration.Dynamic dispatcher = servletContext
          .addServlet("dispatcher", new DispatcherServlet(context));
        
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
    