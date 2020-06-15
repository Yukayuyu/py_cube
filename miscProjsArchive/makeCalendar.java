import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

public class D2_P7Calendar {
    private Formatter f = new Formatter(System.out);

    Date genGreDate(int year, int month, int day) {
        Date datetmp = new GregorianCalendar(year, month, day).getTime();
        return datetmp;
    }

    LocalDate genLocalDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }

    void calendarGen(int year, int month) {
        // System.out.println(lengthOfMonth + " " + dayOfWeek);
        int indent = 6;
        Header(year, month, indent);
        Body(year, month);
    }

    void Header(int year, int month, int indent) {
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < indent; n++) {
            sb.append(" ");
        }
        sb.append(year + "年\n");
        f.format(sb.toString());

        sb.setLength(0); // flush
        sb.append(month + "月\n");
        f.format(sb.toString());
    }

    void Body(int year, int month) {
        int dayOfMonth = 1;
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        int lengthOfMonth = localDate.lengthOfMonth();
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate); // Consider only the first day of the month.
        int d = 0;
        switch (dayOfWeek.toString()) {
            case "MONDAY":
                d = 0;
                break;
            case "TUESDAY":
                d = 1;
                break;
            case "WEDNESDAY":
                d = 2;
                break;
            case "THURSDAY":
                d = 3;
                break;
            case "FRIDAY":
                d = 4;
                break;
            case "SATUARDAY":
                d = 5;
                break;
            case "SUNDAY":
                d = 6;
                break;
        }

        StringBuilder sb = new StringBuilder();
        f.format("月 火 水 木 金 土 日\n");

        // indent the first content line
        for (int j = 6; j > 6 - d; j--) {
            sb.append("   ");
        }
        for (int day = 1; day <= lengthOfMonth; day++) {
            sb = sb.append(String.format("%2.2s ", day));
            d++;
            if (d > 6) {
                d = 0;
                sb = sb.append("\n");
                f.format(sb.toString());
                sb.setLength(0); // flush
            }
        }
        f.format(sb.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] str = input.split("/");
        int year = Integer.parseInt(str[0]);
        int month = Integer.parseInt(str[1]);

        D2_P7Calendar x = new D2_P7Calendar();
        x.calendarGen(year, month);
    }
}
