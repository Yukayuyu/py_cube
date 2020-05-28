import java.util.*;
public class Cp5_ControlFlow{
    public static void main (String[] args){
	char i = 123;
	int k = i++;
	Object o = i++;
	int j = i++;
	i += 1 ;
	System.out.println((int)i);
	System.out.println(o.getClass());
	System.out.println((int)j);
	System.out.println((int)k);
	for(char c = 0; c<100; c++)
	    if(Character.isLowerCase(c))
		System.out.println((int)c+ "character" +c);
	//
	Random rand = new Random(47);
	float f[] = new float[10];
	for(int ii = 0; ii<10; ii++)
	    f[ii] = rand.nextFloat();
	for(float x : f)
	    System.out.println(x);
	for (char c : "Hello".toCharArray())
	    System.out.print(c + " ");
	List<Integer> range = java.util.stream.IntStream.rangeClosed(1, 10).boxed().collect(java.util.stream.Collectors.toList());
	System.out.println(range);
    }
}
