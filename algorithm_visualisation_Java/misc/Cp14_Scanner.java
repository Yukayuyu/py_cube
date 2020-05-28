import java.util.*;
import java.util.regex.MatchResult;

public class Cp14_Scanner {
    static String Data1 = "12, 42, 78";
    static String Data2 = "127.0.0.1@02/10/2005\n" + "127.0.0.2@02/11/2005\n"
            + "[Next log section with different data format]";

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(Data1);
        scanner1.useDelimiter("\\s*, \\s*");
        while (scanner1.hasNextInt()) {
            System.out.println(scanner1.nextInt());
        }
        Scanner scanner2 = new Scanner(Data2);
        String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" + "(\\d{2}/\\d{2}/\\d{4})";
        scanner1.close();
        while (scanner2.hasNext(pattern)) {
            scanner2.next(pattern);
            MatchResult match = scanner2.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.printf("Access on %s from %s\n", date, ip); 
        }
        scanner2.close();
    }
}
