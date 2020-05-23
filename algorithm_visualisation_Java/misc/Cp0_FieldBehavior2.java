class Cp0_FieldBehavior2Base {
    int i = 1;
}


class Cp0_FieldBehavior2 extends Cp0_FieldBehavior2Base {
    int i = 2;

    public static void main(String[] args) {
        Cp0_FieldBehavior2 x = new Cp0_FieldBehavior2();
        System.out.println(x.i);
    }
}
