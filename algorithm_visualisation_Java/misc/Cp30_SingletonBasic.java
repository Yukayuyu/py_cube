class Cp30_SingletonBasicSingleton {
    private static final Cp30_SingletonBasicSingleton INSTANCE = new Cp30_SingletonBasicSingleton();

    private Cp30_SingletonBasicSingleton() {}

    public static Cp30_SingletonBasicSingleton getInstance() {
        return INSTANCE;
    }
}


@SuppressWarnings("all")
public class Cp30_SingletonBasic {
    public static void main(String[] args) {
        Cp30_SingletonBasicSingleton s = Cp30_SingletonBasicSingleton.getInstance();
    }
}
