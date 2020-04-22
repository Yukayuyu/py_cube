import java.rmi.activation.ActivationException;

interface testInterface {
    void f() throws Exception;
}


class TestAnInitCause extends Exception {
}


class TestMyException1 extends Exception {
    final String string;

    TestMyException1() {
        super();
        string = "default";
    }

    TestMyException1(String str) {
        string = str;
    }

}


class TestMyException2 extends Throwable {
    TestMyException2() {
        super();
    }

    TestMyException2(String message, Throwable cause) {
        super(message, cause);
    }
}


public class Cp13_MyExceptionAdvanced implements testInterface {

    public void g() throws TestMyException2 {
        System.out.println("method g");
        // throw (TestMyException2) new TestMyException2().initCause(new ActivationException());
        // The same as:
        throw (TestMyException2) new TestMyException2("a message", new TestAnInitCause());
        // ! throw (new TestMyException()).initCause(new ActivationException());
    }

    public void f() throws TestMyException1 {
        System.out.println("method f");
        throw (TestMyException1) new TestMyException1();
    }
    // This works fine. Since TestMyException1 is a sub-class of Exception.

    // ! public void f() throws TestMyException2 {
    // ! System.out.println("method f");
    // ! throw(TestMyException2)new TestMyException2();
    // ! }
    // This won't compile. Since TestMyException2 is not a sub-class of Exception.

    void run() {
        try {
            g();
            f();
            // If one exception happens, process stopped.
        } catch (TestMyException1 e) {
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
        // ! catch (TestMyException2 e) {} // Won't compile since Already been caught.
        // Even when g() is commented out (i.e. No TestMyException2 thrown).
    }


    public static void main(String[] args) {
        Cp13_MyExceptionAdvanced x = new Cp13_MyExceptionAdvanced();
        x.run();
    }
}
