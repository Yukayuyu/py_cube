class Cp2_UpBase {
    void f() {
        System.out.println("base");
    }
}


class Cp2_UpChild extends Cp2_UpBase {
    @Override
    void f() {
        System.out.println("child");
    }
}


public class Cp2_Upcasting {
    public static void main(String[] args) {
        Cp2_UpChild x1 = new Cp2_UpChild();
        Cp2_UpBase x2 = new Cp2_UpChild();
        x1.f();
        x2.f();
        Cp2_UpBase xf = (Cp2_UpBase) x1;
        xf.f();
    }
}
