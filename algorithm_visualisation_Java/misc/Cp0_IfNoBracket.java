public class Cp0_IfNoBracket {
    public static void main(String[] args) {
        if (true)
            System.out.println("1");
        System.out.println("2");
        int i = 0;
        while (i++ < 10)
            System.out.println("3");
        System.out.println("4");
    }
}
