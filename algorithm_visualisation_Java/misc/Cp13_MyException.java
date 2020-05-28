@SuppressWarnings("all")
class SimpleException extends Exception {
    public SimpleException() {
        super();
    }

    public SimpleException(String msg) {
        super(msg);
    }
}


@SuppressWarnings("all")
class HighlevelException extends Exception {
}


public class Cp13_MyException {
    public void f(String msg) throws SimpleException {
        System.out.println("Throw SimpleException from f()");
        throw new SimpleException();
    }

@SuppressWarnings("all")
    public static void main(String[] args) {
        Cp13_MyException sed = new Cp13_MyException();
        try {
            try {
                sed.f("mmmmsg");
            } catch (SimpleException e) {
                e.printStackTrace(System.err);
                System.out.println("++++++++++");
                throw (HighlevelException) new HighlevelException().initCause(e);
            }
        } catch (HighlevelException h) {
            h.printStackTrace(System.err);
            System.out.println((double) new Integer(9));
        }
    }
}
