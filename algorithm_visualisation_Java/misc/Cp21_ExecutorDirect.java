import java.util.concurrent.*;

public class Cp21_ExecutorDirect implements Executor {
    public void execute(Runnable r) {
        r.run();
    }
}
