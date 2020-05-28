interface Cp0InterfaceVsAbstractClassInterface {
    int j = 20;
    // ! private int z = 1; // private field not allowed.
}


@SuppressWarnings("all")
abstract class Cp0InterfaceVsAbstractClassAbstractClass {
    int i = 10;

    private int j = 1; // private field is allowed.

    private void f() {
        System.out.println(
                "0. Single inheritance (although possible using inner class) vs. Multiple implementation.");
        System.out.println(
                "1. Abstract class can contain a real method, thus be used to define default behavoir for a function.");
        System.out.println(
                "2. Abstract class also cannot be instantiated using keyword *new*. However it could be, if it contains none abstract method.");
        System.out.println(
                "3. Abstract class can contain non-final Variables. While all Variables declared in Interface are by default final.");
        System.out.println(
                "4. Abstract class can have private/protected members, while members of an interface are public(though inner interface can be trivia). For more info check the comments in main().");
    }

    abstract void g();

    // Abstract method cannot have a body.
    protected void callf() {
        f();
    }
}


public class Cp0_InterfaceVsAbstractClass extends Cp0InterfaceVsAbstractClassAbstractClass
        implements Cp0InterfaceVsAbstractClassInterface {
    void g() {}

    void supercallf() {
        super.callf();
    }

@SuppressWarnings("all")
    public static void main(String[] args) {
        Cp0_InterfaceVsAbstractClass x = new Cp0_InterfaceVsAbstractClass();
        x.callf();
        // f() is not inherited since it is private.
        // Without overwritting, x.callf() uses base class's namespace, same as calling:
        // x.supercallf();
        System.out.println("++x.i = " + ++x.i);
        System.out.println("x.j = " + x.j);
        System.out.println("j is final static variable: Cp0InterfaceVsAbstractClassInterface.j = "
                + Cp0InterfaceVsAbstractClassInterface.j);
        // ! System.out.println("++x.j = " + ++x.j);
        // Cannot assign a value to final variable j.
    }
}
