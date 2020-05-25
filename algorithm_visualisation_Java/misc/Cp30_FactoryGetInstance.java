import java.lang.reflect.Constructor;

class Cp30_FactoryGetInstanceBase {
    String name;
    String ID;

    Cp30_FactoryGetInstanceBase() {
        System.out.println("EnterNameAndID");
    }

    Cp30_FactoryGetInstanceBase(String name, String ID) {
        this.name = name;
        this.ID = ID;
    }
}


class Cp30_FactoryGetInstanceFactory {
    public static Cp30_FactoryGetInstanceBase baseGetInstance(String... arg) throws Exception {
        Class<?> c = Class.forName("Cp30_FactoryGetInstanceBase");
        // return (Cp30_FactoryGetInstanceBase) c.newInstance(arg);
        // Class.newInstance() will only succeed if the constructor is has zero arguments and is
        // already accessible. Otherwise, it is necessary to use Constructor.newInstance() as in the
        // above example.
        Constructor<?>[] ctors = c.getDeclaredConstructors();
        return (Cp30_FactoryGetInstanceBase) ctors[1].newInstance(arg[0], arg[1]);


    }
}


public class Cp30_FactoryGetInstance {
    public static void main(String[] args) throws Exception { // must be handled
        Cp30_FactoryGetInstanceBase x = Cp30_FactoryGetInstanceFactory.baseGetInstance("a", "b");
        System.out.println(x.name);
        System.out.println(x.ID);
    }
}
