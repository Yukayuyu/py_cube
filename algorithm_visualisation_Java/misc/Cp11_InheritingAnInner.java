class Cp11_InheritingAnInnerA {
    class Cp11_InheritingAnInnerAInner {
        int i;

        Cp11_InheritingAnInnerAInner() {
            i = 1;
            System.out.println("hi");
        }
    }
}


public class Cp11_InheritingAnInner extends Cp11_InheritingAnInnerA.Cp11_InheritingAnInnerAInner {
    // ! InheritInner(){}
    Cp11_InheritingAnInner(Cp11_InheritingAnInnerA x) {
        x.super(); // Construct the enclosuring super class first.
    }

    public static void main(String[] args) {
        Cp11_InheritingAnInnerA xa = new Cp11_InheritingAnInnerA();
        Cp11_InheritingAnInner xaa = new Cp11_InheritingAnInner(xa);
        System.out.println(xaa.i);
        Cp11_InheritingAnInnerA.Cp11_InheritingAnInnerAInner xb =
                xa.new Cp11_InheritingAnInnerAInner();
        System.out.println(xb.i);
    }
}
