class AClass{
    private AClass(){}
    static AClass makeAClass(){
	return new AClass();
    }
}
public class Cp7_Private{
    /**
       class AClass{
	private AClass(){}
	static AClass makeAClass(){
	    return new AClass(); //non-static variable this cannot be referenced from a static context
	}
       }
    */
	
    public static void main (String[] args){
	AClass x = AClass.makeAClass();
	System.out.println(x);
    }
}
