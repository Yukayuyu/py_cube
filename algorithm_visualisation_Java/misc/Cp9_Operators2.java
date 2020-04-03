public class Cp9_Operators2{
    int i = 1;
    int j = 1;
    void method(){
	if (++i > 1)
	    System.out.println(i);
	else
	    System.out.println("ha"+i);
    }
    void method2(){
	if (j++ > 1)
	    System.out.println(j);
	else
	    System.out.println("ha"+j);
    }
    public static void main (String[] args){
	Cp9_Operators2 x = new Cp9_Operators2();
	x.method(); //2, plus first 
	x.method2(); //ha2, operation first
    }
}
