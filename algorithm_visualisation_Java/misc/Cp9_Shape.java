class Shape{
    void draw(){
	System.out.println("Shape.draw");
    }
}
class Circle extends Shape{
    void draw(){
	System.out.println("Circle.draw");
    }
    void drawP(){
	System.out.println("Circle.drawP");
    }
}
public class Cp9_Shape{
    public static void main (String[] args){
	Shape x = new Circle();
	x.draw();
	System.out.println(x.getClass()); //Class Circle
	Circle y = new Circle();
	y.drawP();
	//! x.drawP(); //cannot find symble
    }
}
