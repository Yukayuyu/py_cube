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


public class Cp12_ArrayListWithGeneric {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for (int i = 0; i < 3; i++)
            apples.add(new Apple());
        // ! apples.add(new Orange()); //Compile time error.
        for (int i = 0; i < apples.size(); i++)
            System.out.println((apples.get(i)).id());
        for (Apple c : apples)
            System.out.println(c.id());
    }
}
