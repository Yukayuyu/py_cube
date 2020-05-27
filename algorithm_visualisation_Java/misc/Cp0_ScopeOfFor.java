class Cp0_ScopeOfFor {
    public static void main(String[] args) {
        // same goes to for loop, cannot redeclare existing local variable;
        // however if the var is only used in a functional body, this is legal
        for (int val = 0; val < 2; val++) {
            System.out.println("looping");
        }
        // ! System.out.println(val);
        // Effective only within for loop's scope.

        int i;
        // ! int i; // duplicate local variable; illegal
        for (i = 1; i < 5; i++) {
            System.out.print("i= " + i++ + " "); // possible
        }
        System.out.println("\n" + i);
    }
}
