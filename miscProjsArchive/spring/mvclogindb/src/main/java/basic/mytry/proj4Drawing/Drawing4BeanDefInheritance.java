package basic.mytry.proj4Drawing;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Drawing4BeanDefInheritance {
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
                "mvclogindb/src/main/java/basic/mytry/proj4Drawing/beansTriangle4BeanDefInheritance.xml");
       Triangle4BeanDefInheritance triangle = (Triangle4BeanDefInheritance) context.getBean("triangleChild");
        triangle.draw();
        System.out.println(triangle.getPointA());
        System.out.println(triangle.getPointB());
        System.out.println(triangle.getPointC());
        triangle.printPoints();
    }
}