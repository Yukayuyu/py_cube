class Temp{
    private String s;
    Temp() {
	s = "the temp's constructor";
    }
    public String toString() {
	return
	    s + "and toString overloadiXCX";
    }
}
public class Cp8_ToString{
    public static void main (String[] args){
	Temp x = new Temp();
	System.out.println(x);
    }
}
