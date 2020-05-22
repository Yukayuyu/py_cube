import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Cp19_DirectoryListerAnonymousInner {
    public static void main(String[] args) {
        File path = new File("./ocjp8");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            // list(FilenameFilter filter)
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]);

                public boolean accept(File dir, String name) {
                    return pattern.matcher(name).matches();
                }
            });
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);

        }
    }
}
