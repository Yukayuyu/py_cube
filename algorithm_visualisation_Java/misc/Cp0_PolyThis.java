class Cp0_InheritedThisBase {
    String name = "parentName";

    void run() {
        System.out.println(name);
    }
}


public class Cp0_PolyThis extends Cp0_InheritedThisBase {
    String name = new String("child name");

    // @Override
    // void run() {
    // System.out.println(name);
    // }

    public static void main(String[] args) {
        Cp0_InheritedThisBase x = new Cp0_PolyThis();
        x.run();
    }
}
