public class Cp5_VarArgsOverloading{
    //A Static Method
    static void overloadingFunction(int argsss){ //argsss is joking
	System.out.printf("Method1%n" + argsss + "%n");
    }
    static void overloadingFunction(Object[] args, String... someStrs){
	for(Object obj : args)
	    System.out.print(" " + obj);
	System.out.println("next, trailers.");
	for(String s : someStrs)
	    System.out.print(" " + s);
	System.out.println();
    }
@SuppressWarnings("all")
    public static void main (String[] args){
	overloadingFunction(99);
	overloadingFunction(new Object[]{new Integer (1)});
	overloadingFunction(new Object[]{new Integer(47), new Float(3.141)}, new String("firstString"), "secondString");
    }
}
