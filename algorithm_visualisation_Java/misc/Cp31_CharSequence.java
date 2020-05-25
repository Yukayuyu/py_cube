class Cp31_CharSequence {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcdefg");
        CharSequence seq = sb.subSequence(1, 5);
        System.out.println(seq);
        String str = new StringBuilder(seq).substring(1, 3);
        System.out.println(str);
    }
}
