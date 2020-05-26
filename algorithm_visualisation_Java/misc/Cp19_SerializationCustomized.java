import java.io.*;
import java.time.*;

class Cp19_SerializationCustomizedData implements Serializable {
    static final long serialVersionUID = 3L;

    String name = "defaultName";
    String ID = "defaultID";
    LocalDateTime dateSerialized;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name); // or customized write method.
        out.writeUTF(ID);
        dateSerialized = LocalDateTime.now();
        out.writeObject(dateSerialized);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        name = in.readUTF(); // or customized read method.
        ID = in.readUTF();
        dateSerialized = (LocalDateTime) in.readObject();
    }
}


public class Cp19_SerializationCustomized {

    public static void main(String[] args) {
        Cp19_SerializationCustomizedData objOut = new Cp19_SerializationCustomizedData();
        objOut.name = "aName";
        objOut.ID = "anID";

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("./Cp19_SerializationCustomizedData.out");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objOut);
            out.close();
            fileOut.close();
            System.out.println("SerializationFinished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
