public class Cp3_Class{
    static class DataOnly{
	// 
	int i;
	String c;
	boolean b;
    }
    static class StaticTest{
	static int i = 1;
    }
@SuppressWarnings("all")
    public static void staticTestMethod(){
	StaticTest St1 = new StaticTest();
	StaticTest St2 = new StaticTest();
	St1.i++;
	St2.i++;
	St2.i = St2.i * 2;
	System.out.println("StaticTest_i= " + StaticTest.i);
    }
    public static void main (String[] args){
	DataOnly datax = new DataOnly();
	datax.i = 1;
	datax.c = "str";
	System.out.println("i "+datax.i + " c "+datax.c);
	staticTestMethod();
    }
}
