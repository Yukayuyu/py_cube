class Cp14_Split {
    public static void main(String[] args) {
        String str = String.valueOf(". abcd e&& f. f.");
        String[] strArr = str.split("\\w ");
        for (String s : strArr)
            System.out.print(s);
    }
}
