import java.util.*;
interface test9i{
}
class test9 implements test9i{
    void f(){
        System.out.println("f");
}
    public static void main(String[] args) {
        test9 x = new test9();
        List<test9i> l = new ArrayList<>();
        l.add(x);
        l.get(0).f();
}
}
