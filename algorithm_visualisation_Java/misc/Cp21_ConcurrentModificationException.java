import java.util.*;

class Cp21_ConcurrentModificationException {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        for (String str : list) {
            if ("C".equals(str))
                list.remove(str);
        }
        for (String str : list) {
            System.out.println(str);
        }
    }
}
