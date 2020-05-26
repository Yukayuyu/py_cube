import java.util.*;
import java.util.function.Predicate;

class Cp21_AvoidConcurrentModificationException {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b"));
        list.add("c");

        // method1
        List<String> toRemove = new ArrayList<>();
        Predicate<String> p = (s) -> s.equals("b");
        for (String str : list) {
            if (p.test(str)) // or any Condition
                toRemove.add(str);
        }
        list.removeAll(toRemove);
        System.out.println(Arrays.asList(list));

        // method2
        list.removeIf(s -> (s.equals("c")));
        System.out.println(Arrays.asList(list));
        // Iterator<String> iter = list.iterator();
    }
}
