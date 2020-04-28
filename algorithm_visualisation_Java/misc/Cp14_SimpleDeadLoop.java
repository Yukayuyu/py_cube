public class Cp14_SimpleDeadLoop{
    private static int counter = 0;
    public Cp14_SimpleDeadLoop retThis(){
        return this;
    }
    public static void main(String[] args) {
        System.out.println("main is called, count = " + ++counter);
        Cp14_SimpleDeadLoop x = new Cp14_SimpleDeadLoop();
        System.out.println(x.retThis());
        // retThis return an pointer to this, which should not directly call main.
    }
}
