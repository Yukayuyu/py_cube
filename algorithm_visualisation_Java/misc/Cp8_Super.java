class Cp8_SuperA {
    Integer i;

    Cp8_SuperA(int i) {
        this.i = i;
        System.out.println("A, this.i = " + this.i.toString());
    }

    void methodA() {
        System.out.println("methodA");
    }
}


class Cp8_SuperB extends Cp8_SuperA {
    Cp8_SuperB(int i) {
        super(i);
    }

    void getB() {
        System.out.println("B, this.i = " + this.i.toString());
    }

    void methodA() {
        System.out.println("methodA in B");
        super.methodA();
    }
}


class Cp8_SuperB2 extends Cp8_SuperA {
    Cp8_SuperB2(int i) {
        super(i);
    }

    Cp8_SuperB2(int i, int j) {
        super(i);
        this.i = i + j;
        System.out.println("B2, this.i = " + this.i.toString());
    }
}


@SuppressWarnings("all")
public class Cp8_Super {
    public static void main(String[] args) {
        Cp8_SuperB x = new Cp8_SuperB(2);
        x.getB();
        x.methodA();
        Cp8_SuperB2 y = new Cp8_SuperB2(2, 3);
    }
}
