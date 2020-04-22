abstract class testBaseClass {
    private int i = 10;

    int getter() {
        return i;
    }

    abstract void f();
}


public class test extends testBaseClass {
    private int i = 20;

    int getter() {
        return i;
    }

    int sgetter() {
        return super.getter();
    }

    void f() {}

    public static void main(String[] args) {
        test x = new test();
        System.out.println(x.sgetter());

    }
}
