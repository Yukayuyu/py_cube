import java.lang.reflect.*;

public class Cp15_ReflectionDumpMethods {
    public static void main(String args[]) {
        String[] arg = {"java.util.Stack"};
        try {
            Class<?> c = Class.forName(arg[0]);
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
