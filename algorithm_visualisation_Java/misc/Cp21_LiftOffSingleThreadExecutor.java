import java.util.concurrent.*;

public class Cp21_LiftOffSingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            e.execute(new Cp21_LiftOff()); // single thread.
            // Executors.newSingleThreadExecutor().execute(new Cp21_LiftOff()); // 5 threads
        }
        e.shutdown();
        System.out.println("Waiting for LiftOff");
    }
}
