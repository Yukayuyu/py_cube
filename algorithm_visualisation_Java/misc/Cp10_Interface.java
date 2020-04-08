interface I01 {
  // int i = 0;
  public void ipp();
}
abstract A02{
  // int i = 0;
  public void ipp();
}


class C01 implements I01 {
  private int i = 11;

  public void ipp() {
    System.out.println(++i);
  }
}


public class Cp10_Interface {
  public static void main(String[] args) {
    C01 x = new C01();
    x.ipp();
  }
}
