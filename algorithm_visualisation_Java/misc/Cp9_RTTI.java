class Useful {
    public void f() {
    }

    public void g() {
    }
}

class MoreUseful extends Useful {
    public void f() {
    }

    public void g() {
    }

    public void u() {
    }

    public void v() {
    }
}

public class Cp9_RTTI {
    public static void main(String[] args) {
        Useful[] x = { new Useful(), new MoreUseful() };
        x[0].f();
        x[1].g();
        System.out.println();
        ((MoreUseful) x[0]).u(); // ClassCastException thrown
        ((MoreUseful) x[1]).u(); // RTTI
    }
}
