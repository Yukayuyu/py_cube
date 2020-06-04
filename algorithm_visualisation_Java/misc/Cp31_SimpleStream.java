import java.util.*;
import java.util.stream.Collectors;

class Cp31_SimpleStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List l = list.stream().filter(e -> e > 2).filter(e -> e < 7).collect(Collectors.toList());
        System.out.println(l);
        List<String> sa = new ArrayList<>(Arrays.asList("a", "c", "b", "d"));
        String s = sa.stream().collect(Collectors.joining("/"));
        System.out.println(s);
    }
}
