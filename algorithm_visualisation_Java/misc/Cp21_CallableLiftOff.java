import java.util.concurrent.*;

class Cp21_CallableLiftOffCallable implements Callable<String> {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public Cp21_CallableLiftOffCallable() {}

    public Cp21_CallableLiftOffCallable(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());;
            Thread.yield();
        }
    }

    public String call() {
        return "The return string is: " + "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!")
                + "), ";
    }
}


public class Cp21_CallableLiftOff {

    public static void main(String[] args) throws Exception {
        ExecutorService e = Executors.newSingleThreadExecutor();
        String s = e.submit(new Cp21_CallableLiftOffCallable()).get();
        // The *<T> Future<T>* in the Oracle document means:
        // The e.submit() returns a Generic Object, Future<T>;
        // Then, the get() is executed for the Callable<String>;
        // Which returns an object of type V = String;
        System.out.println(s);
        e.shutdown();
    }
}
