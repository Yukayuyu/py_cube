import java.lang.Thread;

class Cp21_SleepException extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                System.out.println(getName() + " " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("interuptted");
        }
    }

    public static void main(String[] args) {
        Cp21_SleepException x = new Cp21_SleepException();
        Cp21_SleepException y = new Cp21_SleepException();
        x.start();
        y.start();
    }
}


