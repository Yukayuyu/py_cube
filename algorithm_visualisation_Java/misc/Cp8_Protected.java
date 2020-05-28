@SuppressWarnings(value = {"all"})
class Cp8_ProtectedBase01{
    private static int i;
    private int j = 9;
    protected static int h = 10;
    protected void setI(int k){
	this.i = k;
    }
    void getI(){
	System.out.println(this.i);
    }
    private void setJ(int k){
	this.j = k;
	System.out.println(this.j);
    }
}
public class Cp8_Protected extends Cp8_ProtectedBase01{
    //private static int i = 3; 
    private static int i = 4;
    private static int h = 11;
    public static void main (String[] args){
	Cp8_Protected x = new Cp8_Protected();
	x.setI(1);
	x.getI();
	System.out.println(i);
	System.out.println(h);
	//System.out.println(j); //j has private access in Cp8_ProtectedBase01
	//x.setJ(2); //invalid because the method is private.
	//System.out.println(j); // j has private access in Cp8_ProtectedBase01;
    }
}
