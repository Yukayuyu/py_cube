package basic.mytry.proj4Drawing;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Drawing5BeanLifeCycle {
    public static void main(String[] args) {
        /**
         * Abs instead of a pale appContext
         */
        AbstractApplicationContext context = new FileSystemXmlApplicationContext(
                "mvclogindb/src/main/java/basic/mytry/proj4Drawing/beansTriangle5BeanLifeCycle.xml");
        context.registerShutdownHook();
       Triangle5BeanLifeCycle triangle = (Triangle5BeanLifeCycle) context.getBean("triangle");

        triangle.draw();
        System.out.println(triangle.getPointA());
        System.out.println(triangle.getPointB());
        System.out.println(triangle.getPointC());
    }
}