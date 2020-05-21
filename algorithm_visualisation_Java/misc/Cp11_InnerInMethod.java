abstract class Cp11_Wrapping {
    int j = 10;

    abstract int value();

    abstract void whosyourdaddy();
}
// the Cp11_Wrapping does not has to be an abstract class.


public class Cp11_InnerInMethod {
    int j = 20;

    public Cp11_Wrapping contents() {
        return new Cp11_Wrapping() {
            private int i = 11;

            public int value() {
                return i;
            }

            public void whosyourdaddy() {
                System.out.println("this.j = " + this.j);
                System.out.println("super.j = " + super.j);
            }
        };
    }

    public static void main(String[] args) {
        Cp11_InnerInMethod p = new Cp11_InnerInMethod();
        Cp11_Wrapping c = p.contents();
        System.out.println(c.value());
        c.whosyourdaddy();
    }
}
