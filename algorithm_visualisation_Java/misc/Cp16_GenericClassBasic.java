class Cp16_GenericClassBasicBase {
}


public class Cp16_GenericClassBasic<T> {
    private T a;

    public Cp16_GenericClassBasic(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Cp16_GenericClassBasic<Cp16_GenericClassBasicBase> x =
                new Cp16_GenericClassBasic<Cp16_GenericClassBasicBase>(
                        new Cp16_GenericClassBasicBase());
        Cp16_GenericClassBasicBase a = x.get(); // no cast needed
    }
}
