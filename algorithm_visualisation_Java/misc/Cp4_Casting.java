public class Cp4_Casting{
    public static void main (String[] args){
	int i = 100;
	long ii = i; //Auto Widening
	int j = (int) ii; //Narrawing, cast required.
	System.out.println("" + i + ii + j);
	boolean x = false;
	boolean y = true;
	System.out.println(x | y);

	int k = 2147483647;
	float l = (float) k;
	System.out.println(l); //IEEE 754
    }
}
