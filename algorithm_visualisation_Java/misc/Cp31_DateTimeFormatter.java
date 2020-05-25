import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class Cp31_DateTimeFormatter {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.of(2015, 8, 31, 0, 0);
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(time.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(time.format(DateTimeFormatter.ISO_DATE_TIME));
        ZoneId z = ZoneId.systemDefault();
        System.out.println(z);
        ZonedDateTime timeZoned = ZonedDateTime.of(time, z);
        System.out.println(timeZoned.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
        System.out.println(timeZoned.format(DateTimeFormatter.ISO_INSTANT));
    }
}
