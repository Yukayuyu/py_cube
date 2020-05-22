import java.io.*;

public class Cp19_BasicFileOutput {
    static String file = "Cp10_BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(Cp19_BufferedInputFile.read("Cp19_BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        out.close();
        System.out.println(Cp19_BufferedInputFile.read(file));;
    }
}
