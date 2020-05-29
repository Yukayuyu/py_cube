class Cp0_SuperThisInheritanceBase {

    Cp0_SuperThisInheritanceBase() {}

    Cp0_SuperThisInheritanceBase(int i) {}

    Cp0_SuperThisInheritanceBase(int i, int j) {}

}


public class Cp0_SuperThisInheritance extends Cp0_SuperThisInheritanceBase {

    Cp0_SuperThisInheritance() {
        super(1);
        System.out.println("child default");
    }

    Cp0_SuperThisInheritance(String s) {
        super(1);
        // ! this();
        // the constructor call is not allowed unless at the first line.
        // i.e. no overloadding call.
        System.out.println("child String s");
    }

    Cp0_SuperThisInheritance(String s1, String s2) {
        // if the base default is not defined, then an constructor must be called.
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Cp0_SuperThisInheritance x = new Cp0_SuperThisInheritance("h");
    }
}
