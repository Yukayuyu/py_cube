package ocjp8s;

public class p61 {
    String s1 = "1";
    String s2 = "1";

    public static void main(String[] args) {
        // p61Base x = new p61Base();
        p61 x = new p61();
        System.out.println(x.s1 == x.s2);
        String a = "sample";
        String b = new String("sample");
        System.out.println(a == b);
    }
}
