@FunctionalInterface
interface Cp0_ScopesInterface {
    String f(int val);
}


class Cp0_Scopes {
    public static void main(String[] args) {
        // ! int val; //lambda var cannot redeclare existing local variable;
        Cp0_ScopesInterface x = val -> "a";
        System.out.println(x.f(1));

        // same goes to for loop, cannot redeclare existing local variable;
        // however if the var is only used in a functional body, this is legal
        for (int val = 0; val < 2; val++) {
            System.out.println("looping");
        }
        // same as the following:
        int i;
        // ! int i; // duplicate local variable; illegal
    }
}
