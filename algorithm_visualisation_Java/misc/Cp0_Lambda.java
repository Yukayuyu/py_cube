@FunctionalInterface
interface Cp0_Action {
    public void eat();
}


public class Cp0_Lambda {
    public static void main(String[] args) {
        class innerClass implements Cp0_Action {
            public void eat() {
                System.out.println("Eating in Innerclass");
            }
        }
        innerClass t1 = new innerClass();
        t1.eat();
        System.out.println("------InnerClass-------");
        Cp0_Action obj1 = new Cp0_Action() {
            @Override
            public void eat() {
                System.out.println("Eating in Anonymous InnerClass");
            }
        };
        obj1.eat();
        Cp0_Action obj2 = () -> System.out.println("Eating in Lambda");
        obj2.eat();
    }
}
