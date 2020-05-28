@SuppressWarnings("all")
public class Cp5_Label {
    public static void main(String[] args) {
        boolean flag = true;
        label1: for (;;) {
            for (;;) {
                System.out.println("super break");
                break label1;
            }
        }
        System.out.println("out");
        for (;;) {
            label2: for (int i = 0; i < 4; i++) {
                for (;;) {
                    System.out.println("super continue" + i);
                    continue label2;
                }
            }
            System.out.println("out");
            break;
        }
    }
}
