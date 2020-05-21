class Cp0_PrivateFieldOtherClassGetterContainer {
    private int i = 1;

    public void setter(int value, Cp0_PrivateFieldOtherClassGetterContainer x) {
        x.i = value;
    }

    public int getter() {
        return this.i;
    }
}


public class Cp0_PrivateFieldOtherClassGetter {
    public static void main(String[] args) {
        Cp0_PrivateFieldOtherClassGetterContainer a =
                new Cp0_PrivateFieldOtherClassGetterContainer();
        Cp0_PrivateFieldOtherClassGetterContainer b =
                new Cp0_PrivateFieldOtherClassGetterContainer();
        a.setter(10, a);
        a.setter(10, b);
        System.out.println(b.getter());
    }
}
