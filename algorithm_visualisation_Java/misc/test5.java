public class test5 {
    static Class c;

    static String s;
    static char cc;


    public static void main(String[] args) {
        Class o = null;
        Object obj = null;
        System.out.println(c); // null
        System.out.println(o); // null
        System.out.println(s); // null
        System.out.println(cc); // blank char
        System.out.println(obj);
        // byte a = 0b10000000;
        byte b = 0b01000000;
        byte bb = -127;
        System.out.println(bb);
        short ss = 0xFFFFFFFF;
        short sss = -32768;
        System.out.println(sss);
        Object ooo = new String("ha");
        String s = (String) ooo;
        System.out.println(s);
        Object oooo = new Object();
        String ssss = (String) oooo;
        System.out.println(ssss);

        // ! boolean boa = 0;
        boolean boa = true;
        boolean bob = false;
        // ! System.out.println(boa - bob);



    }
}
