import java.util.Arrays;
public class Cp8_Final{
    final Integer[] a = {1,2,3};
    final int[] b = {1,2,3};
    private final int i; //blank finals
    Cp8_Final(){
        this.i = 1;
        //this.i = 2; //variable i might already have been assigned.
    }
    public static void main (String[] args){
	Cp8_Final x = new Cp8_Final();
	x.a[1] = 99;
	x.b[1] = 99;
	System.out.println(Arrays.toString(x.a));
	System.out.println(Arrays.toString(x.b));
	System.out.println(x.a);
	System.out.println(x.b);
	System.out.println(x.i);
    }
}
