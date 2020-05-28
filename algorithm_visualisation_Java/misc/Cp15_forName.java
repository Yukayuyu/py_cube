abstract class Cp15_Base {
    abstract void m();
}


class Cp15_Extend extends Cp15_Base {
    void m() {}

    static void myStaticMethod() {
        System.out.println("Cp15_Extend static method.");
    }

}

@SuppressWarnings("all")
public class Cp15_forName {
    public static void main(String[] args) throws ClassNotFoundException, Exception {
        Class t = Class.forName("java.lang.Thread");
        System.out.println("t " + t);
        Class<?> x = Class.forName("Cp15_Extend");
        Cp15_Extend obj = new Cp15_Extend();
        System.out.println("obj.getClass() " + obj.getClass());
        System.out.println("obj.getClass().getName() " + obj.getClass().getName());
        System.out.println("------------------------");
        // ! x.myStaticMethod();
        System.out.println("x " + x);
        System.out.println("x.getName() " + x.getName());
        System.out.println("x.getClass() " + x.getClass()); // class
        System.out.println("x.getSuperclass() " + x.getSuperclass());
        System.out.println("------------------------");

        System.out.println(obj.getClass());
        System.out.println(obj.getClass().getTypeName());
        System.out.println(obj.getClass().toString());
        System.out.println(obj.getClass().toGenericString());
        System.out.println("------------------------");
        Object yy = x.newInstance();
        System.out.println(yy.getClass());
        Class xSuper = x.getSuperclass();
        System.out.println(xSuper);
        // ! Object xIllegalAbsObj = xSuper.newInstance();
        // InstantiationExceptionConstructorAccessorImpl
    }
}
