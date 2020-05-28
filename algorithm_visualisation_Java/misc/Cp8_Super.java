class A{
    Integer i;
    A(int i){
	this.i = i;
	System.out.println("A, this.i = " + this.i.toString());
  }
    void methodA(){
	System.out.println("methodA");
    }	
}
class B extends A{
    B(int i){
	super(i);
    }
    void getB() {
	System.out.println("B, this.i = " + this.i.toString());
    }
    void methodA(){
        System.out.println("methodA in B");
	super.methodA();
    }
}
class B2 extends A{
    B2(int i){
	super(i);
    }
    B2(int i, int j){
	super(i);
	this.i = i + j;
    System.out.println("B2, this.i = " + this.i.toString());
  }
}
@SuppressWarnings("all")
public class Cp8_Super {
    public static void main (String[] args){
	B x = new B(2);
	x.getB();
	x.methodA();
	B2 y = new B2(2,3);
    }
}
