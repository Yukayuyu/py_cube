import java.io.*;

public class Cp19_DeserializationCustomized {
    public static void main(String[] args) {
        Cp19_SerializationCustomizedData d;
        try {
            FileInputStream in = new FileInputStream("./Cp19_SerializationCustomizedData.out");
            ObjectInputStream objIN = new ObjectInputStream(in);
            d = (Cp19_SerializationCustomizedData) objIN.readObject();
            objIN.close();
            in.close();
            System.out.println(d.name);
            System.out.println(d.ID);
            System.out.println(d.dateSerialized);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
