import java.io.*;

public class Cp19_DeserializationBasic {
    public static void main(String[] args) {
        Cp19_SerializationBasicData d;
        try {
            FileInputStream in = new FileInputStream("./Cp19_SerializationBasicData.out");
            ObjectInputStream objIN = new ObjectInputStream(in);
            d = (Cp19_SerializationBasicData) objIN.readObject();
            objIN.close();
            in.close();
            System.out.println(d.name);
            System.out.println(d.ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
