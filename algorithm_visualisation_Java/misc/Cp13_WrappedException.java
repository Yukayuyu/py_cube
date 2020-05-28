import java.io.IOException;

@SuppressWarnings("all")
class TestMyThrowable extends Throwable {
    TestMyThrowable() {
        super();
    }

    TestMyThrowable(String message, Throwable cause) {
        super(message, cause);
    }
}


class WrappedExceptions {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new TestMyThrowable();
                case 1:
                    throw new IOException();
                default:
                    return;
            }
        } catch (Throwable t) {
            throw new RuntimeException(t); // RuntimeException(Throwable cause);
        }
    }
}


public class Cp13_WrappedException {

    public static void main(String[] args) {
        WrappedExceptions x = new WrappedExceptions();
        x.throwRuntimeException(3);
        x.throwRuntimeException(0);
    }
}
