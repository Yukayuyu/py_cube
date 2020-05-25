import java.time.LocalDate;

public class Cp31_LocalDate {
    public static void main(String[] args) {
        LocalDate a = LocalDate.of(2015, 1, 1);
        LocalDate b = LocalDate.parse("2015-01-01");
        System.out.println(a.equals(b));
    }
}
