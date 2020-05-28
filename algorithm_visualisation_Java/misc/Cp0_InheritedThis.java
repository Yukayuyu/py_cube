class Cp0_InheritedThisBase {
    String name = "parentName";

    void run() {
        System.out.println(name);
    }
}


public class Cp0_InheritedThis extends Cp0_InheritedThisBase02 {
    String name = new String("child name");

    public static void main(String[] args) {
        Cp0_InheritedThis x = new Cp0_InheritedThis();
        x.run();
    }
}
