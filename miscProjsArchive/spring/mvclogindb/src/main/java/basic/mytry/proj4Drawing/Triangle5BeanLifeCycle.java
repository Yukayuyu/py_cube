package basic.mytry.proj4Drawing;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

public class Triangle5BeanLifeCycle implements InitializingBean, DisposableBean{
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ApplicationContext context = null;
    private List<Point> points;

    public void draw() {
        System.out.println("triangle drawing");
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
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
    public void afterPropertiesSet() throws Exception {
        System.out.println("Triangle5BeanLifeCycle: Bean has been initialized"); 
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Triangle5BeanLifeCycle: DisposableBen destory method has been called");
    }
}