import java.lang.invoke.*;

public class Cp0_BootStrapMethod {
    public static void main(String[] args) throws Throwable {
        CallSite cs = StringConcatFactory.makeConcatWithConstants(MethodHandles.lookup(),
                "makeConcatWithConstants", MethodType.methodType(String.class, int.class),
                "text + String: \u0001");

        int x = 2;
        String result = (String) cs.dynamicInvoker().invokeExact(x);
        System.out.println(result);

        x = 3;
        result = (String) cs.dynamicInvoker().invokeExact(x);
        System.out.println(result);
    }
}
