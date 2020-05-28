class Base00{
    Base00(){
	System.out.println("Base00Constructor");
    }
    static void base00Static(){
	System.out.println("base00StaticMethod");
    }
}
class Base01{
    Base01(){
	System.out.println("Base01Constructor");
    }
    static void base01FirstMethod(){
	System.out.println("base01FirstMethod");
    }
}
@SuppressWarnings("all")
class Extend01 extends Base01{
    Extend01(){
	System.out.println("Extend01Constructor");
    }
    private static void extend01SecondMethod(){ // not called
	System.out.println("extend01SecondMethod"); 
    }
}
@SuppressWarnings("all")
public class Cp8_CompileOrder{
    Cp8_CompileOrder(){
	System.out.println("Cp8_CompileOrderConstructor"); // not called
    }
    public static void main (String[] args){
	Base00.base00Static(); //a static method is called. but the constructor is not loaded.
	System.out.println("Cp8_CompileOrderMain");
	Extend01 x = new Extend01();
	x.base01FirstMethod();
    }
}
