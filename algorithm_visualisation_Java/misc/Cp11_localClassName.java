class Cp11_localClassName {
    private int i = 5;

    public void calculate() {
        final int j = 10;
        class Cp11_localClassNameInner { // Cp11_localClassName$1Cp11_localClassNameInner.class
            int j = 9;

            public void multiply() {
                // ! System.out.println(ii * j); // compile error
                System.out.println(i * j); // 45
                System.out.println(i * this.j); // 45
                // if comment out line 7, 50.
            }
        }
        Cp11_localClassNameInner x = new Cp11_localClassNameInner();
        x.multiply();
    }

    public static void main(String[] args) {
        Cp11_localClassName z = new Cp11_localClassName();
        z.calculate();
    }
}
