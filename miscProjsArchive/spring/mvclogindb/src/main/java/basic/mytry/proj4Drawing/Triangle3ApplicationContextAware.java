package basic.mytry.proj4Drawing;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle3ApplicationContextAware implements ApplicationContextAware, BeanNameAware {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ApplicationContext context = null;

    public void draw() {
        System.out.println("triangle drawing");
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context=context; 
    }

    @Override
    public void setBeanName(String name) { 
        System.out.println("Bean name is: " + name);
    }
}