public class Cp13_AllException {

    public static void main(String[] args) {
        try {
            throw new Exception("MyException");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println(e.getLocalizedMessage());
            System.out.println();
            System.out.println(e);
            System.out.println();
            e.printStackTrace(System.err);
        }
    }
}
