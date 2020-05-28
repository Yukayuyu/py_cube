import java.util.*;

class Cp31_CollectionSimpleSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 2, 9, 5));
        Comparator<? super Integer> c = (a, b) -> {
            return b - a;
        };
        Collections.sort(list, c);
        System.out.println(list);
        Collections.sort(list, c.reversed());
        System.out.println(list);
    }
}
