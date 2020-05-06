import java.io.*;

public class Cp14_SimpleRead {
    public static BufferedReader input =
            new BufferedReader(new StringReader("Sir Robin of Camelot \n22 1.61803"));

    public static void main(String[] args) {
        try {
            System.out.println("What is the name?");
            String name = input.readLine();
            System.out.println(name);
            System.out.println("Age? Number?");
        } catch (IOException e) {
            System.err.println("I/O exception");
        }
    }
}
