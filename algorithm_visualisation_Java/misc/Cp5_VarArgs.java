@SuppressWarnings("all")
public class Cp5_VarArgs{
    //A Static Method
    static Object obj = new Integer(1);
    static Object i = new Integer(1);

    static void printArray(Object[] args){
	for(Object obj : args)
	    System.out.print(" " + obj);
	System.out.println();
    }
    public static void main (String[] args){
	int i = 1;
	Object c = (Object) i;
	System.out.println(c.getClass());

	printArray(new Object[]{
		new Integer(47), new Float(3.141)
	    });
    }
}
