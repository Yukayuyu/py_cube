import java.io.IOException;

public class Cp13_ReturnJVMCode {
    static String f(int i) {
        try {
            System.out.println("try");
            if (i == 1)
                throw new IOException();
        } catch (Exception e) {
            return "Catch";
        } finally {
            System.out.println("Finally");
            // return "Finally";
        }
        return "C";
    }

    public static void main(String[] args) {
        System.out.println(f(1));
    }
}
