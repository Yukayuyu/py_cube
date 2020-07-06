package basic.mytry.proj4Drawing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DrawingAppAutoWiring {
    /**
     * The ClassPath method search only at ClassPath, which is /src/main/java/*.xml
     * in this case
     * 
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext(
                "mvclogindb/src/main/java/basic/mytry/proj4Drawing/beansTriangleAutoWire.xml");
        TriangleAutoWire triangle = (TriangleAutoWire) context.getBean("triangle");
        triangle.draw();
        System.out.println(triangle.getPointA());
        System.out.println(triangle.getPointB());
        System.out.println(triangle.getPointC());
    }
}