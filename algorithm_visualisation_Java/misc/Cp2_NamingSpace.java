public class Cp2_NamingSpace {
    int a = 1;
    private static boolean fun(){
	System.out.println("abc");
	return false;
    }
    public static void main(String[] args){
	fun();
    }
	 
}
//System.out.println("efg", a);

