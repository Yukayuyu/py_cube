import java.util.Arrays;
class Base01{
    private int i = 1;
    final void method01(){ i++; }
    private void method02() { i = i * 2;}
    final int get(){return i;}
}
class E01 extends Base01{
    private int i = 2;
    //@Override
    //method does not override or implement a method from a supertype
    private void method03() { i = i * 3;}
    //@Override
    //void method01(){ i++; } //Cannot Override
}
public class Cp8_FinalMethods{
    public static void main (String[] args){
	E01 x = new E01(); 
	x.method01();
	//x.method03();
	//method03() has private access in E01
	System.out.println(x.get());
    }
}
