public class Cp21_LiftOffBasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new Cp21_LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
