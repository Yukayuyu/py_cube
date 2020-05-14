interface Cp0_LambdaAction {
    public void eat();
}


enum Food {
    Apple;
}


public class Cp0_Lambda {
    public void method2(Food food, new Cp0_LambdaAction ){
        
    }

    public static void main(String[] args) {
        class innerClass implements Cp0_LambdaAction {
            public void eat() {
                System.out.println("eating by innerclass");
            }
        }
        innerClass t1 = new innerClass();
        t1.eat();
        System.out.println("------InnerClass-------");


    }


}

