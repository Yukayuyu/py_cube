public class test {
    static int i = 1;

    public static void main(final String[] abc) throws Exception {
        HelloWorld.main(abc);
        abc[0] = "10";
        abc = new String[]{"13"};
        System.out.println(abc[0]);
        
        abc[0] = "1";
        System.out.println(abc[0]);
        String[] args = new String[] {};
        HelloWorld.main(args);
        //HelloWorld x = new HelloWorld();
        byte[] b = new byte[2];
        b[0] = 100;
        b[1] = 0x2E;
        // String s = new String(x.b, "UTF-8");
        // String s = (b, 0,1)
        System.out.println(b.getClass());
        // String s = new String("hi");
        String s = new String(b, 0, 1, "UTF-8");
        System.out.println(s);
        String s2 = new String("ABCDEFG");
        String base = new String("base");
        StringBuilder sb = new StringBuilder();
        sb.append(base);
        sb.append(s2, 1, 4);
        System.out.println(sb.toString());
        byte k = 0x2E;
        System.out.println(k < 47);

    }
}
