package ocjp8s;

public class p250_1 {
    public static void main(String[] args) {
        try {
            String[] array = {"A", "B", "C"};
            System.out.println(array[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("D");
        } finally {
            System.out.println("E");
        }
    }
}
