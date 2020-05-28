interface Cp13testInterface {
    void f() throws Exception;
}


@SuppressWarnings("all")
class Cp13TestAnInitCause extends Exception {
}


@SuppressWarnings("all")
class Cp13TestMyException extends Exception {
    final String string;

    Cp13TestMyException() {
        super();
        string = "default";
    }

    Cp13TestMyException(String str) {
        string = str;
    }

}


@SuppressWarnings("all")
class Cp13TestMyThrowable extends Throwable {
    Cp13TestMyThrowable() {
        super();
    }

    Cp13TestMyThrowable(String message, Throwable cause) {
        super(message, cause);
    }
}


public class Cp13_MyExceptionAdvanced implements Cp13testInterface {

    public void g() throws Cp13TestMyThrowable {
        System.out.println("method g");
        // throw (Cp13TestMyThrowable) new Cp13TestMyThrowable().initCause(new
        // ActivationException());
        // The same as:
        throw (Cp13TestMyThrowable) new Cp13TestMyThrowable("a message", new Cp13TestAnInitCause());
        // ! throw (new TestMyException()).initCause(new ActivationException());
    }

    public void f() throws Cp13TestMyException {
        System.out.println("method f");
        throw (Cp13TestMyException) new Cp13TestMyException();
    }
    // This works fine. Since TestMyException is a sub-class of Exception.

    // ! public void f() throws Cp13TestMyThrowable {
    // ! System.out.println("method f");
    // ! throw(Cp13TestMyThrowable)new Cp13TestMyThrowable();
    // ! }
    // This won't compile. Since Cp13TestMyThrowable is not a sub-class of Exception.

    void run() {
        try {
            g();
            f();
            // If one exception happens, process stopped.
        } catch (Cp13TestMyException e) {
            System.out.println("catch Exception1");
            System.out.println(e.string); // The e thrown is a sub-class of the Exception specified
                                          // by the interface.
            e.printStackTrace();
            System.out.println("+++++++++++++++");
        } catch (Throwable t) {
            System.out.println("catch Throwable");
            t.printStackTrace();
            System.out.println("+++++++++++++++");
            System.out.println(t.getCause());
        }
        // ! catch (Cp13TestMyThrowable e) {} // Won't compile since Already been caught.
        // Even when g() is commented out (i.e. No Cp13TestMyThrowable thrown).
    }


    public static void main(String[] args) {
        Cp13_MyExceptionAdvanced x = new Cp13_MyExceptionAdvanced();
        x.run();
    }
}
