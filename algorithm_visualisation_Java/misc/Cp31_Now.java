import java.time.*;

public class Cp31_Now {
    public static void main(String[] args) {
        LocalDateTime nowLDT = LocalDateTime.now();
        System.out.println(nowLDT);
        LocalDate nowLD = LocalDate.now();
        System.out.println(nowLD);
        LocalTime nowLT = LocalTime.now();
        System.out.println(nowLT);
    }
}
