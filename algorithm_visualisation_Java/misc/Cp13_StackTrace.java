public class Cp13_StackTrace {
    static void f() {
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace())
                System.out.println(ste);
            System.out.println("+++++");
            e.printStackTrace();
        }
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        f();
        System.out.println("-------------------------");
        f();
        System.out.println("-------------------------");
        g();
        System.out.println("-------------------------");
    }
}
