import java.lang.reflect.Array;
import java.util.Arrays;
@SuppressWarnings("all")
public class Cp5_Array{
    public static void main (String[] args){
	int[] a1 = {1, 2, 3, 4, 5};
	int[] a2;
	a2 = a1; //Only changes the pointer. 
	for (int i = 0; i < Array.getLength(a2); i++)
	    a2[i] += 1;
	System.out.println(Arrays.toString(a1));
	//int?
	int j1 = 1;
	int j2;
	j2 = j1;
	j2 += 1;
	System.out.println(j1);
	//or when length unknown, call a *new*
	int[] a;
	int the_Length = 9; //can be any random number unknowned till runtime.
	a = new int[the_Length]; //can be any value or function output within []
	System.out.println(Arrays.toString(a));
    }
}
