import java.util.*;
import java.util.function.*;

class Cp31_Function {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30);
        Function<Integer, Boolean> x = s -> {
            return list.contains(s);
        };
        System.out.println(x.apply(50));
        System.out.println(x.apply(10));
    }
}
