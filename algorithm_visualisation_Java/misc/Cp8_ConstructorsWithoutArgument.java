class Base01{
    int i = 1;
    int k = 5;
    Base01(){
	int i = 2;
	System.out.println("Base01Constructor");
    }
}
public class Cp8_ConstructorsWithoutArgument extends Base01{
    int k = 3;
    Integer j;
    Cp8_ConstructorsWithoutArgument(){
	j = new Integer(4);
	System.out.println("mainConstructor");
    }
    public static void main (String[] args){
	Cp8_ConstructorsWithoutArgument x = new Cp8_ConstructorsWithoutArgument();
	System.out.println(x.i);	
	System.out.println(x.j);	
	System.out.println(x.k); // x.k == 3;	
	//
	Base01 y = x;
	System.out.println(y.i);	
	System.out.println(y.k); // y.k == 5;
	//! System.out.println(y.j);	
    }
}
