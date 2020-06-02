package ocjp8s;

public class p250 {
    public static void main(String[] args) {
        try {
            try {
                String[] array = {"A", "B", "C"};
                System.out.println(array[3]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("D");
            } finally {
                System.out.println("E");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("F");
        } finally {
            System.out.println("G");
        }
    }
}
