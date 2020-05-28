interface Cp10_InterfaceI01 {
    int i = 0;
    //All variables defined in an interface are implicitly static final.

    public void ipp();
}


abstract class Cp10_InterfaceA02 {
    int i = 0;

    public abstract void ipp();
}


class Cp10_InterfaceC01 extends Cp10_InterfaceA02 implements Cp10_InterfaceI01 {
    private int i = 11;

    public void ipp() {
        System.out.println(++i);
    }
}


public class Cp10_Interface {
    public static void main(String[] args) {
        Cp10_InterfaceC01 x = new Cp10_InterfaceC01();
        x.ipp();
    }
}
