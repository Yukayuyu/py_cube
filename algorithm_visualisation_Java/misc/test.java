public class test {
  private int i01 = 1;
  private static int i = 1;

  public int getI01() {
    return i01;
  }

  public void setI01(int i01) {
    this.i01 = i01;
  }

  void method0() {
    i++;
  }

  public static void main(String[] args) {
    test x = new test();
    x.method0();
    System.out.println(test.i);
    int j = test.i - 10;
    switch (j) {
      case 0:
        System.out.println(j);
        break;
      case 1:
        System.out.println(">10");

        break;
      case 2:
        break;
      default:
        System.out.println("df");
        break;
    }

    String[] arr = {"cat", "fish", "cow", "a"};
    System.out.println(arr);
    if (i > 0) {
      i++;
    } else {
      i--;
    }
  };

  void m02() {
    i++;
    String[] sA = new String[] {"a", "b", "c"};
    sA.clone();
  }

  void m3() {}

  /*
   * Annotation
   * 
   * @author k,asd, a,a
   */
  @Annot(x = 1, y = 2)
  public void m1() {}

  Runnable r = () -> process();
};
