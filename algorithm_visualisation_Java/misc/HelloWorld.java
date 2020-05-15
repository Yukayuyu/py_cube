import java.util.Calendar;

public class HelloWorld {
    int i;

    HelloWorld() {
        i = 1;
    }

    void run() {
        Calendar c = Calendar.getInstance();
        c.set(2020, 06, 02);
        int i = c.get(4);
        System.out.println(c.WEEK_OF_MONTH);
        System.out.println(i);

    }

    public static void main(String args[]) {
        HelloWorld obj = new HelloWorld();
        obj.run();

    }
}
