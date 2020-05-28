class Cp0_FieldsBase {
    static String staticString = "FieldBaseString";
    static {
        System.out.println("FieldBase static block will be initialized no matter what.");
    }

    static void staticMethod() {
        System.out.println("FieldBase static method");
    }
}


public class Cp0_FieldsInitializationOrder {
    // ! final int i; // compile fail without initialization in constructor.
    int j;
    int zz; //
    final int finalZ; // if multiple constructor, need initialization multiple times.
    static int staticI;
    static String s1 = "Static Field Order Matters, if reference in the static block.";

    static {
        System.out.println("Static initialization block first");
        System.out.println(s1);
    }

    Cp0_FieldsInitializationOrder() {
        System.out.println("Constructor Third, on first new obj call");
        this.j = 11;
        System.out.println(this.j);
        j = 12;
        System.out.println(this.j);
        finalZ = 100;
    }

    Cp0_FieldsInitializationOrder(int j) {
        j = 12;
        System.out.println("j with conflict, output the value in the scope of constructor = " + j);
        System.out.println("this.j with conflict = " + this.j);
        finalZ = 2;
    }

    static void run() {
        System.out.println("Other obsolete static methods");
    }

@SuppressWarnings("all")
    public static void main(String[] args) {
        System.out.println("Other static methods second, staticI = " + staticI);
        System.out.println("staticI = " + staticI);
        Cp0_FieldsInitializationOrder x = new Cp0_FieldsInitializationOrder(200);
        System.out.println(x.s2);
        System.out.println("--------------------");

        // System.out.println(Cp0_FieldsBase.staticString);
        Cp0_FieldsBase.staticMethod();
        // Cp0_FieldsBase x2 = new Cp0_FieldsBase();

    }

    static String s2 = "However does not matter if referenced in a static method";
}
