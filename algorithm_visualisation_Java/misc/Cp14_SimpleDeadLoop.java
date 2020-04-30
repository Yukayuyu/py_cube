public class Cp14_SimpleDeadLoop {
    private static int counter = 0;

    public String toString() {
        return "this" + this;
    }

    public Cp14_SimpleDeadLoop retThis() {
        return this;
    }

    public static void main(String[] args) {
        System.out.println("main is called, count = " + ++counter);
        Cp14_SimpleDeadLoop x = new Cp14_SimpleDeadLoop();
        System.out.println(x);
        // ! System.out.println(System.out.println("Hi"));
        // return this implicitly call this.toString();
    }
}
