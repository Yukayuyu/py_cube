abstract class Cp0_ConvarianceAndContravarianceBase {
    protected void f() {
        System.out.println("basemethod");
    }

    abstract protected Number g();

    abstract void h(int i);

    abstract void j(int i);
}


public abstract class Cp0_CovarianceAndContravariance extends Cp0_ConvarianceAndContravarianceBase {
    // ! void f() {} // cannot reduce the visibility.

    // ! public int f() {return 1;} // return type not compatible.

    @Override
    public void f() {}

    @Override
    public Integer g() {return 1;}; // this function g() is covariant because it returns a subclass of
                           // Number.

    @Override
    void h(int j) {} // no error

    // ! @Override // the j() is Contravariance since (Object i)is a super class of (int)
    void j(Object i) {} // java does not process this as overriding.
}
