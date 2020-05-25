public class Cp31_StartsWith {
    public static void main(String[] args) {
        String s = "abcde";
        // ! System.out.println(s.startsWith('a'));
        System.out.println(s.startsWith("a")); // true
        System.out.println(s.startsWith("b", 1)); // true
    }
}
