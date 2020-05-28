class Cp0_nonstaticFunctionCallInConstructorBase {
    private int i = 1;
    private int j = 1;

@SuppressWarnings("all")
    Cp0_nonstaticFunctionCallInConstructorBase(int j) {
        f();
        this.f();
        i = j; // however if a field named j, this won't work, must use this.j = j;
        j = j; // will run, but no effect
        this.j = j;
    }

    void f() {
        System.out.println("function call");
    }

    void printer() {
        System.out.println(i);
        System.out.println(j);
    }
}


public class Cp0_nonstaticFunctionCallInConstructor {
    public static void main(String[] args) {

        Cp0_nonstaticFunctionCallInConstructorBase x =
                new Cp0_nonstaticFunctionCallInConstructorBase(22);
        x.printer();
    }


}
