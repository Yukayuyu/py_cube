interface Incrementable {
    void increment();
}


// Very simple to just implement the interface:
class Callee1 implements Incrementable {
    private int i = 0;

    public void increment() {
        i++;
        System.out.println(i);
    }
}


class MyIncrement {
    public void increment() {
        System.out.println("Other operation");
    }

    static void f(MyIncrement mi) {
        mi.increment();
    }
}


// If another implementation of increment() is desired, must use an inner class:
class Callee2 extends MyIncrement {
    private int i = 0;

    public void increment() {
        super.increment();
        i++;
        System.out.println(i);
    }

    private class Closure implements Incrementable {
        public void increment() {
            // Specify outer-class method, otherwise infinite recursion occurs.
            Callee2.this.increment();
        }
    }

    Incrementable getCallbackReference() {
        return new Closure();
    }

    Incrementable getCallbackReference2() {
        return new Incrementable() {
            public void increment() {
                Callee2.this.increment();
                System.out.println(
                        "Anonymous class or lambda new class can also access methods in the enclosing class, e.g. use the EnclosingClass.this.methodName();");
            }
        };
    }
}



class Caller {
    private Incrementable callbackReference;

    Caller(Incrementable input) {
        callbackReference = input;
    }

    void go() {
        callbackReference.increment();
    }
}


public class Cp11_Callback {
    public static void main(String[] args) {
        Callee1 c1 = new Callee1();
        Callee2 c2 = new Callee2();
        MyIncrement.f(c2);
        Caller caller1 = new Caller(c1);
        Caller caller2 = new Caller(c2.getCallbackReference());
        Caller caller22 = new Caller(c2.getCallbackReference2());
        caller1.go();
        caller1.go();
        // caller2.go();
        caller2.go();
        caller22.go();
        caller22.go();
        caller22.go();
    }
}
