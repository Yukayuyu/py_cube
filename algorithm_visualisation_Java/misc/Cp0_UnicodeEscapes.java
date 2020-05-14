public class Cp0_UnicodeEscapes {
    public static void main(String[] args) {
        char c = '\u0041';
        System.out.println(c);
        // String d = "\\u005cu005a";
        // String d = '\ u 0 0 5 c u 0 0 5 a';
        // ! System.out.println("\\uu005cu005c");
        // char[] ca1 = '\uu005cu005c';
        System.out.println("\u00a5123");
        System.out.println("\\u2126=\u2126");
        System.out.println("\uu2126\u2126");
        // ! System.out.println('\uu005cu005c');
    }
}
