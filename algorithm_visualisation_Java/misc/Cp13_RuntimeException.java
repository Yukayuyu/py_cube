public class Cp13_RuntimeException {
    static void f() {
        throw new RuntimeException("from f(): ");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
    }
}
