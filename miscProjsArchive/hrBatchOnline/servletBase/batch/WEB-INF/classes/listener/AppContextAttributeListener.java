package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionListener;

public final class AppContextAttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, HttpSessionListener {
    private ServletContext context = null;
    @Override
    public void attributeAdded(ServletContextAttributeEvent event){
        context = event.getServletContext();
        log(event.getSource() + "Context attribute added" + event.getName() + event.getValue());
    }
     /**
     * Log a message to the servlet context application log.
     * @param message
     *            Message to be logged
     * @author Craig R. McClanahan
     */
    private void log(String message) {
        if (context != null)
            context.log("ContextListener: " + message);
        else
            System.err.println("ContextListener(from null context): " + message); 
    } 
}