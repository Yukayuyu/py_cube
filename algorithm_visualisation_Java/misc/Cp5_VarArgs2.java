public class Cp5_VarArgs2{
    //A Static Method
    
    static void f(Object[] args, String... someStrs){
	for(Object obj : args)
	    System.out.print(" " + obj);
	System.out.println("next, trailers.");
	for(String s : someStrs)
	    System.out.print(" " + s);
	System.out.println();
    }
@SuppressWarnings("all")
    public static void main (String[] args){
	int i = 1;
	Object c = (Object) i;
	System.out.println(c.getClass());
	f(new Object[]{
		new Integer(47), new Float(3.141)
	    });
	f(new Object[]{new Integer(47), new Float(3.141)}, new String("firstString"), "secondString");
    }
}
