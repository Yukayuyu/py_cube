public class Cp11_DotNewThis {
    void thisIS() {
        System.out.print("thisIS ");
    }

    public class Inner {
        public Cp11_DotNewThis getOuter() {
            return Cp11_DotNewThis.this;
        }

        public Cp11_DotNewThis.Inner getInner() {
            return Cp11_DotNewThis.Inner.this;
        }
    }

    public static void main(String[] args) {
        Cp11_DotNewThis dn = new Cp11_DotNewThis();
        Cp11_DotNewThis.Inner dnI = dn.new Inner();
        System.out.println(dnI); // Cp11_DotNewThis$Inner@726f3b58
        dnI.getOuter().thisIS(); // thus the outer function can be called.
        System.out.println(dnI.getOuter());
        System.out.println(dnI.getInner()); // Cp11_DotNewThis$Inner@726f3b58
    }
}
