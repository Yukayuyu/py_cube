@SuppressWarnings("all")
public class Cp0_UnreachableCode {
    public static void main(String[] args) {
        if (true) {
            System.out.println("true");
        } else {
            System.out.println("unreachable statement1, compilable");
        }
        return;
        // ! System.out.println("unreachable statement2 after return");
    }
}
