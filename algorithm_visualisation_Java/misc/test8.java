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
        List<Integer> list2 = {1,2,3,4,};
    }
}


class test9 {
    void f() {
        System.out.println("f");
    }
}
