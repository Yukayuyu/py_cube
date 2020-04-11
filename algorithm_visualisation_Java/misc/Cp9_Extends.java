class Base02 {
    void baseMethod() {}
}


class Ext01 extends Base02 {
    void extMethod() {
        System.out.println("extMethod");
    }
    // Does not override because not the same method.
    // @Override
    //    void baseMethod(int i) {
    //        return i;
    //    }
}


public class Cp9_Extends {
    public static void main(String[] args) {
        // polymorphism
        Base02 x = new Ext01();
        x.baseMethod();
        // ! x.extMethod(); This, the downcast does not work.
    }
}
