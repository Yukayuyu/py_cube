import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cp14_MatchInString {
    void matchesAndLookingAt() {
        String s = "-1231234123";
        Pattern p = Pattern.compile("-\\d*");
        Matcher m = p.matcher(s);
        System.out.println("maches(): " + m.matches()); // matches the whole string.
        System.out.println("LookingAt(): " + m.lookingAt()); // matches from the start.
    }

    public static void main(String[] args) {
        Cp14_MatchInString x = new Cp14_MatchInString();
        x.matchesAndLookingAt();
        System.out.println("----------------");
        System.out.println("String: \"" + args[0] + "\"");
        for (String arg : args) {
            System.out.println("Reg Expression: " + arg);
            Pattern p = Pattern.compile(arg);
            Matcher m = p.matcher(args[0]);
            while (m.find()) { // matches from anywhere
                System.out.println(m.group() + " atpos: " + m.start() + "-" + (m.end() - 1));
            }
        }
    }
}
