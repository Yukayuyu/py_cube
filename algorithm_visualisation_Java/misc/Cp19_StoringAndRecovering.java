import java.io.*;

public class Cp19_StoringAndRecovering {
    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("Cp19_tmpData.txt")));
        out.writeDouble(3.14159);
        out.writeUTF("This is UTF str1");
        out.writeDouble(1.1123);
        out.writeUTF("This is UTF str2");
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("Cp19_tmpData.txt")));
        System.out.println(in.readDouble());;
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());;
        System.out.println(in.readUTF());
        in.close();
    }
}
