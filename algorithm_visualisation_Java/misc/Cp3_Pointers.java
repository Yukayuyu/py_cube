//import java.lang.Object.*;
import java.util.Arrays;
public class Cp3_Pointers {
    private static boolean fun(){
	String s = new String ("ab");
	//String s;
	//s = "ab";
	//String s = "ab";
	//Those should be illgal in C/C++. And are special cases in Java hence should be avoided.
	System.out.println(s);
	return false;
    }
    private static void fun2(){
	char c = 'x';
	System.out.println(c);
	Character d = c;
	System.out.println(d);
	char e = d;
	System.out.println(e);
	float i = 3;
	System.out.println("float i= " + i);
	char j = 33; //unicode 0021 is "!"
	System.out.println("char j= " + j);
    //check later
	//String f = new BigInteger(String, 9);
	//Systm.out.println(f);

    }

@SuppressWarnings("all")
    public static void fun3(){
	int[] an_int_array = {1, 2, 3};
	System.out.println(an_int_array);
	Class c = an_int_array.getClass();
	System.out.println("haha: "+ c.getName());
        String e = Arrays.toString(an_int_array);
	System.out.println("hahae: "+ e);
	System.out.println("haha2: "+ Arrays.toString(an_int_array));
	//null array pointer
	int[] null_array;
	//System.out.println("nullarray: " + Arrays.toString(null_array));
	//Compile error: variable null_array might not have been initialized
    }
	   
    public static void main(String[] args){
	fun();
	fun2();
	fun3();
    }
	 
}
//System.out.println("efg", a);

