@SuppressWarnings("all")
class Cp0_ScopeTryCatchFinally2 {
    String val = "7";

    public void doStuff(String str) {
        int num = 0;
        try {
            String val = str;
            num = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            System.out.println("error");
        } finally {
            int i = 13;
        }
        System.out.println("val = " + val + ", num = " + num);
        // ! System.out.println(i);
    }

    public static void main(String[] args) {
        new Cp0_ScopeTryCatchFinally2().doStuff("9");
    }
}
