class Cp0_IfWithoutCurlyBracket {
    public static void main(String[] args) {
        int a = 10;
        if (a++ > 10)
            if (a < 100)
                a--;
            else
                a--;
        else
            a++;
        System.out.println(a);
    }
}
