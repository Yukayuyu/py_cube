public class Cp0_OverloadTrivia {
    void f(double i, double j) {
        System.out.println("double double");
    }


    void f(long i, int j) {
        System.out.println("long int");
    }

    void f(double i, int j) {
        System.out.println("double int");
    }

    void f(int i, double j) {
        System.out.println("int double");
    }

    public static void main(String[] args) {
        Cp0_OverloadTrivia x = new Cp0_OverloadTrivia();
        // x.f(new Integer(1), 1);
        // x.f(new Double(1), 1);
        // x.f(1, 1.0);
        // x.f(1, 1f);
        int z = 1;
        x.f(1.0, z);
        // however if ambiguous, compile error.
    }
}
