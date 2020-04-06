import static java.lang.Math.PI;
import static java.lang.System.out;

public class Cp4_Operators {
    public static void main(String[] args) {
        System.out.print("import static test1\n");
        out.println("import static test1");
        double x = PI, y = 2, z = 3;
        double a = x + y - 2 / 2 + z;
        double b = x + (y - 2) / (2 + z);
        out.println("a = " + a + "b = " + b);
        TestClass anValue = new TestClass();
        out.println(anValue.i);
        anValue.i = 1;
        out.println(anValue.i);
    }
}

class TestClass {
    int i;
}
