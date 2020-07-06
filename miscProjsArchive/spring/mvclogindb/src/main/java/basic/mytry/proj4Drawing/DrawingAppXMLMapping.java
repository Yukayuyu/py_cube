package basic.mytry.proj4Drawing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingAppXMLMapping {
    /**
     * The ClassPath method search only at ClassPath, which is /src/main/java/*.xml
     * in this case
     * 
     * @param args
     */
    public static void main(String[] args) {
        // BeanFactory factory = new XmlBeanFactory(new
        // FileSystemResource("mvclogindb/src/main/java/basic/mytry/proj4Drawing/spring.xml"));
        // ----------------------------------------
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("beansXMLatClassPath.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "mvclogindb/src/main/java/basic/mytry/proj4Drawing/beansTriangle.xml");
        Triangle triangle = (Triangle) context.getBean("triangle");
        triangle.draw();
        System.out.println(triangle.getType());
        System.out.println(triangle.getHeight());
        /**
         * Pass an *Object* argument use XML.
         */
        System.out.println(triangle.getPointA());
        System.out.println(triangle.getPointB());
        System.out.println(triangle.getPointC());
        /**
         * initialize a list use XML.
         */
        triangle.printPointsList();
    }
}