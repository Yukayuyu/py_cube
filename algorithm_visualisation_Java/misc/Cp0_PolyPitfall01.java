interface Cp0_PolyPitfall01Interface {
    void method1();
}


abstract class Cp0_PolyPitfall01Base01 {
    abstract void method2();
}


class Cp0_PolyPitfall01 extends Cp0_PolyPitfall01Base01 implements Cp0_PolyPitfall01Interface {
    public void method1() {};

    void method2() {};

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Cp0_PolyPitfall01Base01 x = new Cp0_PolyPitfall01();
        // ! Cp0_PolyPitfall01Interface z = x;
        // cannot convert ... to ...;
        // i.e. cannot convert a polyed to another unrelated polyed object.
    }
}
