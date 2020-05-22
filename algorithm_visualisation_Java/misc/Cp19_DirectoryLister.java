import java.io.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Cp19_DirectoryLister {
    public static void main(String[] args) {
        File path = new File("./ocjp8");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            // list(FilenameFilter filter)
            list = path.list(new Cp19_DirFilter(args[0]));
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}


class Cp19_DirFilter implements FilenameFilter {
    private Pattern pattern;

    public Cp19_DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
