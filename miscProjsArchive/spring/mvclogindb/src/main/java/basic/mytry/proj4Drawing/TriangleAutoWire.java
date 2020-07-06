package basic.mytry.proj4Drawing;

public class TriangleAutoWire {
    private Point pointA;
    private Point pointB;
    private Point pointC;

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
}