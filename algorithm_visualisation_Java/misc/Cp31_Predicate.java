import java.util.*;
import java.util.function.*;

class Cp31_Predicate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30);
        Predicate<Integer> x = s -> {
            return list.contains(s);
        };
        System.out.println(x.test(50));
        System.out.println(x.test(10));
    }
}
