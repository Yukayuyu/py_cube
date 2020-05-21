@FunctionalInterface
interface Cp0_TempInterface {
    Object o(Cp0_NestedClass x);
}


class Cp0_NestedClass {
    int i = 10;

    Cp0_NestedClass() {
        System.out.println("Cp0_SuperConstructor");
    }

}


public class Cp0_Super {

    public static void main(String[] args) {
        Cp0_NestedClass x = new Cp0_NestedClass();
        Object x3 = new Cp0_TempInterface(x) {


    @Override
    public Object o(Cp0_NestedClass x) {
        // TODO Auto-generated method stub
            return x.super();
    }
    };
}
}


