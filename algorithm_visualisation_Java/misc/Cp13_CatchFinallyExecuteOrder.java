public class Cp13_CatchFinallyExecuteOrder {
    static String f() {
        try {
            String[] array = {"A", "B", "C"};
            System.out.println(array[3]);
            return ("TRYA");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("D");
            e.printStackTrace(System.err);
            return ("DR");
        } finally {
            System.out.println("E");
        }
    }

    public static void main(String[] args) {
        System.out.println(f());
    }

}
