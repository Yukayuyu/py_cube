import java.util.Scanner;

public class Cp13_SevenIsEvil {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // throw err if input == 7
        try {
            head: while (true) {
                String input = scanner.nextLine();
                int i = Integer.parseInt(input);
                if (i == 7) {
                    throw new RuntimeException("7 is evil");
                } else {
                    System.out.println("continue?");
                }
                continue head;
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            scanner.close();
            System.out.println("closed");
        }
        {
            System.out.println("some otherline");
            System.out.println("some otherline");
            System.out.println("some otherline");
        }
    }
}
