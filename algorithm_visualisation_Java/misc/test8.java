import java.util.*;

class test8 {
    public static void main(String[] args) {
        int i = 1;
        for (i = 3; i < 6; i++) {
        }
        System.out.println(i);
        List<test9> list = new ArrayList<>();
        for (test9 j : list) {
            j.f();
        }
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(list3.size());
        List<Integer> list4 = new ArrayList<>();
        System.out.println(list4.size());
        System.out.println(list3.get(1));

    }
}


class test9 {
    void f() {
        System.out.println("f");
    }
}
