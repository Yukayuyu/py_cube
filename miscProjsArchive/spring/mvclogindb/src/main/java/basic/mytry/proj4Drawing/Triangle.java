package basic.mytry.proj4Drawing;

import java.util.List;

public class Triangle {
    private String type;
    private int height;
    private Point pointA;
    private Point pointB;
    private Point pointC;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * use constructor to set bean value
     * @param type
     */
    public Triangle(String type) {
        this.type = type;
    }


    public Triangle(String type, int height) {
        this.type = type;
        this.height = height;
    }
    public void printPointsList(){
        System.out.println(points);
    }
}