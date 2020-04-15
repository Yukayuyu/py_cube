class ParentClass {} 
abstract class absC{
  void f(){
    System.out.println("absC.f");
  }
}
class Z extends ParentClass {
  absC makeC() {
    return new absC (){ 
      @Override
      void f() {
        System.out.println("absC.f.implement");
      }
    };
  }
} //anonymous inner class as an implementation
public class C{
  public static void main(String[] args){
    //! absC x = new absC(); //absC is abstract; cannot be instantiated
    Z z = new Z();
    z.makeC().f();
  }
}