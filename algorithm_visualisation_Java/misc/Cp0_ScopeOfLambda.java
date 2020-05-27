@FunctionalInterface
interface Cp0_ScopeOfLambdaInterface {
    void f();
}


class Cp0_ScopeOfLambda {
    static int valB = 0;

    public static void main(String[] args) {
        int val = 0;
        Cp0_ScopeOfLambdaInterface r = () -> {
            System.out.println(val);
            // ! System.out.println(val++);
            // local variable val must be final or effectively final.

            for (int valB = 0; valB < 5; valB++) {
                // Though possible to conflict with static
                // variables outside the enclosing scope.
            }
        };
        r.f();
    }
}
