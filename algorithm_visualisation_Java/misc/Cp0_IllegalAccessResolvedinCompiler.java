@SuppressWarnings("all")
class Cp0_IllegalAccessBase {
    private int i = 1;

    void illegalF() {
        Cp0_IllegalAccessResolvedinCompiler y = new Cp0_IllegalAccessResolvedinCompiler();
        // ! System.out.println(y.i); //compile error
    }
}


@SuppressWarnings("all")
public class Cp0_IllegalAccessResolvedinCompiler {
    private int i = 2;

    public static void main(String[] args) {
        Cp0_IllegalAccessBase x = new Cp0_IllegalAccessBase();
        // ! System.out.println(x.i); // compile error
        Cp0_IllegalAccessResolvedinCompiler y = new Cp0_IllegalAccessResolvedinCompiler();
        System.out.println(y.i);
    }
}
