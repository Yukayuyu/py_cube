class Cp31_PlusOverloadding {
    static String nullStr2;

    public static void main(String[] args) {
        System.out.println(1 + 2 + 10 + 20 + "30" + 40);
        System.out.println(30 + 40 + " ");
        System.out.println("-------------------------");
        String nullStr1 = null;
        System.out.println(nullStr2);
        nullStr1 += "null";
        nullStr2 += "null";
        System.out.println(nullStr1);
        System.out.println(nullStr2);
    }
}
