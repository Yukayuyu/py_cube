interface Cp10_InterfaceDefaultStaticInterface {
    abstract void abs();

    default void f() {
        System.out.println("default method");
    }

    static void g() {
        System.out.println("static method");
    }
}


public class Cp10_InterfaceDefaultStatic implements Cp10_InterfaceDefaultStaticInterface {
    public void abs() {};

    public static void main(String[] args) {
        Cp10_InterfaceDefaultStatic x = new Cp10_InterfaceDefaultStatic();
        x.f();
        Cp10_InterfaceDefaultStaticInterface.g();
    }
}
