public class Cp0_FieldsInitializationOrder {
    // ! final int i; // compile fail without initialization in constructor.
    int j;
    int zz; //
    final int finalZ; // if multiple constructor, need initialization multiple times.
    static int staticI;

    static {
        System.out.println("Static initialization block first");
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

    public static void main(String[] args) {
        System.out.println("Other static methods second, staticI = " + staticI);
        System.out.println("staticI = " + staticI);
        Cp0_FieldsInitializationOrder x = new Cp0_FieldsInitializationOrder(200);
    }
}
