import java.util.Collection;

public class Cp16_GenericMethodSimple {
    static void Cp16_GenericMethodSimple01(Object[] a, Collection<Object> c) {
        for (Object o : a) {
            c.add(o);
        }
    }

    // However when different type of Object is desired
    // Use the following, i.e. a Generic Method
    static <T> void Cp16_GenericMethodSimple02(T[] a, Collection<T> c) {
        for (T o : a) {
            c.add(o);
        }
    }

    public static void main(String[] args) {}
}
