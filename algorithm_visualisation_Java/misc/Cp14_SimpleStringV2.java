public class Cp14_SimpleStringV2 {
    Integer f() {
        return 2;
    }

    String ff() {
        return "dream ";
    }

    String g(String... x) {
        String result = "";
        for (String s : x)
            result += s;
        return result;
    }

    public static void main(String[] args) {
        Cp14_SimpleStringV2 x = new Cp14_SimpleStringV2();
        String s1 = "I have a ";
        String s3 = x.g(s1, x.ff(), Integer.toString(x.f()));
        // String s2 = "A " + "Simple " + "Concatenated " + "String " + 47;
        System.out.println(s3);
        // System.out.println(s2);
    }
}
