import java.time.*;

@SuppressWarnings("all")
public class Cp31_Duration {
    public static void main(String[] args) {
        LocalDate a = LocalDate.of(2019, 01, 01);
        LocalDate b = LocalDate.of(2019, 02, 01);
        LocalTime t1 = LocalTime.of(13, 30, 1);
        LocalTime t2 = LocalTime.of(14, 1, 45);
        LocalDateTime dt1 = LocalDateTime.of(2019, 01, 01, 13, 10); // yr, month, day, hr, min
        LocalDateTime dt2 = LocalDateTime.of(2019, 01, 02, 13, 10, 30);// yr, month, day, hr, min,
                                                                       // sec
        // Duration x = Duration.between(a, b);
        Duration x = Duration.between(t1, t2);
        Duration y = Duration.between(dt1, dt2);
        System.out.println(x); // PT31M44S
        System.out.println(y);
        System.out.println(y.toHours()); // Gets the number of hours in this duration.

    }
}
