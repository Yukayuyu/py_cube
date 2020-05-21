public class Cp0_DefaultValue {
    int[] ii;
    String[] ss;
    byte[] bb = {'b', 'y'};
    char[] cc = {'a', 'b'};
    int i;
    String s;
    byte b;
    char c;
    Integer I;
    Character C;
    boolean bool;
    char[] ccc;

    public static void main(String[] args) {
        Cp0_DefaultValue x = new Cp0_DefaultValue();
        System.out.println(x.bb); // return object pointer.
        System.out.println(x.cc); // only char[] can be printed
        System.out.println(x.ii); // point to a null object
        System.out.println(x.ss);
        System.out.println(x.i);
        System.out.println(x.s); // point to an null object, same as all wrapper class
        System.out.println(x.b);
        System.out.println(x.c);
        System.out.println("bool:" + x.bool); // false
        System.out.println("I:" + x.I); //
        System.out.println("C:" + x.C);

        System.out.println(x.ccc); // NullPointerException

    }
}
