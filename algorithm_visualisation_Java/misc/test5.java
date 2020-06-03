import java.util.*;

class test5 {
    char[] c = {'a', 'b'};

    static void f(char[] c) {
        c[1] = 'c';
    }

    public static void main(String[] args) {
        List<Integer> p = new ArrayList<>();
        p.add(2);
        p.add(3);
        // p.sort();
        test5 x = new test5();
        f(x.c);
        System.out.println(x.c);
        System.out.println((test5) null);


    }
}
