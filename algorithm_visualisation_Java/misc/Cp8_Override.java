class Lisa {
    void method(String str){
	System.out.println(str);
    }
    void method(int i){
	System.out.println(i + i);
    }
}
class LisaOverride extends Lisa {
    //@Override 
    void method(char c){
	System.out.println("char");
    }
}
    
public class Cp8_Override{
    public static void main (String[] args){
	LisaOverride x = new LisaOverride();
	char c = 'C';
	int i = 9;
	x.method(c);
	x.method(i);
	    
    }
}
