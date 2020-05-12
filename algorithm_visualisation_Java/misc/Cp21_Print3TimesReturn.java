class Cp21_Print3TimesReturnBody implements Runnable {
    static int taskCount = 0;
    private final int id = taskCount++;

    Cp21_Print3TimesReturnBody() {
        System.out.println("Constructing Task No." + id);
    }


    public void run() {
        System.out.println("Task No." + id + " says Hello");
        System.out.println("Task No." + id + " says Hello");
        System.out.println("Task No." + id + " says Hello");
        // Thread.yield();
    }
}


public class Cp21_Print3TimesReturn {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Cp21_Print3TimesReturnBody()).start();
        }
        return;
    }
}

