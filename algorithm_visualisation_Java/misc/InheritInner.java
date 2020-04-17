class A{
    class AInner { 
        int i;
        AInner(){
            i = 1;
            System.out.println("hi");
        }
    }
}
public class InheritInner extends A.AInner{
    //! InheritInner(){}
    InheritInner(A x){
        x.super(); //Though counter intuitive.
    }
    public static void main(String[] args){
        A xa = new A();
        InheritInner xaa = new InheritInner(xa);
        System.out.println(xaa.i);
        A.AInner xb = xa.new AInner();
        System.out.println(xb.i);
    }
}