class Cp8_ConstructorsWithoutArgumentBase01 {
    int i = 1;
    int k = 5;

@SuppressWarnings("all")
    Cp8_ConstructorsWithoutArgumentBase01() {
        int i = 2;
        Integer j = 2;
        System.out.println("Cp8_ConstructorsWithoutArgumentBase01Constructor");
    }

    void method() {
        System.out.println("method in super");
    }
}


public class Cp8_ConstructorsWithoutArgument extends Cp8_ConstructorsWithoutArgumentBase01 {
    int k = 3;
    Integer j;

@SuppressWarnings("all")
    Cp8_ConstructorsWithoutArgument() {
        j = new Integer(4);
        System.out.println("mainConstructor");
    }

    @Override
    void method() {
        System.out.println("method in this");
    }


    public static void main(String[] args) {
        Cp8_ConstructorsWithoutArgument x = new Cp8_ConstructorsWithoutArgument();
        System.out.println(x.i + " x.i's value from super class's field");
        System.out.println(x.j + " x.j's value from this constructor");
        System.out.println(x.k + " x.k's value from this class's field, which overrides the super");
        Cp8_ConstructorsWithoutArgumentBase01 y = x;
        System.out.println(y.i + " y uses super class's naming space");
        System.out.println(y.k + " y uses super class's naming space"); // y.k == 5;
        // ! System.out.println(y.j);
        Cp8_ConstructorsWithoutArgumentBase01 z = new Cp8_ConstructorsWithoutArgument();
        System.out.println(z.k + " z.k Polymorphing, though uses super's field");
        z.method();
        // ! System.out.println(z.j + " z.j Polymorphing, though uses super's field");

    }
}
