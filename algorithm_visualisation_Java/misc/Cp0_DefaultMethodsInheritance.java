interface Cp0_DefaultMethodsInheritanceInterface1 {
    default void method() {
        System.out.println("default method in Interface1.");
    }
}


interface Cp0_DefaultMethodsInheritanceInterface2 extends Cp0_DefaultMethodsInheritanceInterface1 {
    default void method() {
        System.out.println("default method in Interface2.");
    }
}


public class Cp0_DefaultMethodsInheritance implements Cp0_DefaultMethodsInheritanceInterface2 {
    public static void main(String[] args) {
        Cp0_DefaultMethodsInheritance x = new Cp0_DefaultMethodsInheritance();
        x.method();
        Cp0_DefaultMethodsInheritanceInterface1 y = new Cp0_DefaultMethodsInheritance();
        y.method();
    }
}
