public class Cp21_LiftOffMoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Cp21_LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
