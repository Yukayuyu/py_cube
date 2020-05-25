@FunctionalInterface
interface Cp0_Scopes2Interface {
    void f();
}


class Cp0_Scopes2 {
    static int valB = 0;

    public static void main(String[] args) {
        int i = 0;
        for (; i < 5; i++) {
            System.out.println(i++);
        } // local var i can be modified in the for loop body.

        int val = 0;
        Cp0_Scopes2Interface r = () -> {
            for (int valB = 0; valB < 5; valB++) { // can conflict with static variable outside the
                                                   // enclosing scope.
                // ! System.out.println(val++);
                System.out.println(val); // cannot modified local variable val.
            }
        };
        r.f();
    }
}
