import java.util.ArrayList;

class Apple {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}


class Orange {
}


public class Cp12_ArrayListWithoutGeneric {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList apples = new ArrayList();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        // Not prevented from adding an Orange to apples:
        apples.add(new Orange()); // ArrayList takes in Objects, yet Orange is also an object.
        for (int i = 0; i < apples.size(); i++)
            ((Apple) apples.get(i)).id(); // An Orange must be casted into Apple, then parenthesised
                                          // to force evaluation, then its id() method is called,
                                          // which does not exist in Orange.
        // Orange is detected only at run time
    }
}
