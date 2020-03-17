public class Cp5_ArrayLoop{
    public static void main (String[] args){
	Other.main(new String[] {"ah", "ha", "ha" });
    }
}
class Other{
    public static void main (String[] args){
	System.out.println(args);
	for(String x : args)
	    System.out.print(x + "");
    }
}

