class Cp30_SingletonBasicSingleton2 {
    // Bill Pugh Singleton Implementation
    // Prior to Java 5, java memory model had a lot of issues and the above approaches used to fail
    // in certain scenario where too many htreads try to get the instance of the Singleton class
    // simultaneously.
    private static class Cp30_SingletonHolder2 {
        private static final Cp30_SingletonBasicSingleton2 INSTANCE =
                new Cp30_SingletonBasicSingleton2();

    }
    // The private Inner static class is not loaded into memory, until when the getInstance() method
    // is called.


    private Cp30_SingletonBasicSingleton2() {}

    public static Cp30_SingletonBasicSingleton2 getInstance() {
        return Cp30_SingletonHolder2.INSTANCE;
    }
}


@SuppressWarnings("all")
public class Cp30_SingletonImproved {
    public static void main(String[] args) {
        Cp30_SingletonBasicSingleton s = Cp30_SingletonBasicSingleton.getInstance();
    }
}
