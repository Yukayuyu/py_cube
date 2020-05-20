public class Cp0_DoubleEqualCompareResult {
    Double t = 100.33333;
    Double u = 99.33333;
    Double[] i = {t};
    Double[] j = {u};

    public static void main(String[] args) {
        Cp0_DoubleEqualCompareResult x = new Cp0_DoubleEqualCompareResult();
        x.j[0]++;
        System.out.println(x.i[0] == x.j[0]);
    }
}
