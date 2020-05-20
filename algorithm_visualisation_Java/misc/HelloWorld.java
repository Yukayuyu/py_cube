class testBase {

    int i = 1;

    testBase() {
        this.i = 10;
    }

    testBase(int i) {
        this();
        System.out.println(++this.i);
    }

}


public class HelloWorld {

    public static void main(String args[]) {
        System.out.println("1");
        {
            System.out.println("2");
        }
        testBase x = new testBase(3);
        System.out.println(x.i);
    }
}
