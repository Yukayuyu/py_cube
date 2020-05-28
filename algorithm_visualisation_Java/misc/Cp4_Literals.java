public class Cp4_Literals {
    static int i1 = 0x2f;
    static int i2 = 0x2F;
    static char c = 0xffff;

    @SuppressWarnings("all")
    public static void main(String[] args) {
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        //
        int i3 = (byte) 0b1111;
        int i3_2 = 0b1111;

        byte aByte = (byte) 0b00010001;
        short aShort = (short) 0b1111000011110000;
        long l1 = 200L;
        float f2 = 0.1f;
        double d2 = 1D;
        System.out.println(i3);
        System.out.println(l1);
        System.out.println(f2);
        System.out.println(d2);

        // Octal
        int anOctal = 010;
        System.out.println(anOctal);

        // Exponents
        float expFloat = 1.39e-43f;
        float expFloat2 = 1.39e-44f;
        System.out.println(expFloat);
        System.out.println(expFloat / expFloat2);
        double d5 = 1.39e-43d;
        double d6 = 1.39e-44d;
        System.out.println(d5);
        System.out.println(d5 / d6);
        double d7 = 1e-1d;
        double d8 = 1e1d;
        System.out.println(d7);
        System.out.println(d8);
    }
}
