import java.util.ArrayList;

class Apple01 {
    private static long counter;
    private final long id = counter++;

    public long id() {
        return id;
    }
}


class Orage01 {
}

@SuppressWarnings("all")
public class Cp12_ArrayListWithoutGeneric {
    public static void main(String[] args) {
        ArrayList apples = new ArrayList(); // unchecked arrayList initialization.
        for (int i = 0; i < 3; i++)
            apples.add(new Apple01());
        // Not prevented from adding an Orage01 to apples:
        apples.add(new Orage01()); // ArrayList takes in Objects, yet Orage01 is also an object.
        for (int i = 0; i < apples.size(); i++)
            ((Apple01) apples.get(i)).id(); // An Orage01 must be casted into Apple01, then parenthesised
                                          // to force evaluation, then its id() method is called,
                                          // which does not exist in Orage01.
        // Orage01 is detected only at run time
    }
}
