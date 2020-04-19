class SimpleException extends Exception {
    public SimpleException() {
        super();
    }

    public SimpleException(String msg) {
        super(msg);
    }
}


public class Cp13_MyException {
    public void f(String msg) throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        Cp13_MyException sed = new Cp13_MyException();
        try {
            sed.f("mmmmsg");
        } catch (SimpleException e) {
            System.out.println("catch");
            e.printStackTrace(System.err);
        }
    }
}
