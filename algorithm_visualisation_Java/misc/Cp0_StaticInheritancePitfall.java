class Cp0_StaticInheritancePitfallBase {
    static void f() {
        System.out.println("baseF");
    }
}

class Cp0_StaticInheritancePitfall extends Cp0_StaticInheritancePitfallBase {
    static void f() {
        System.out.println("childF");
    }

    public static void main(String[] args) {
        Cp0_StaticInheritancePitfallBase x = new Cp0_StaticInheritancePitfall();
        x.f();
        Cp0_StaticInheritancePitfall y = new Cp0_StaticInheritancePitfall();
        y.f();
    }
}
