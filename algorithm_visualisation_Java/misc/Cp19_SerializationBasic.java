import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cp19_SerializationBasicData implements Serializable {
    static final long serialVersionUID = 2;

    String name = "defaultName";
    String ID = "defaultID";
}


public class Cp19_SerializationBasic {
    public static void main(String[] args) {
        Cp19_SerializationBasicData objOut = new Cp19_SerializationBasicData();
        objOut.name = "aName";
        objOut.ID = "anID";
        try {
            FileOutputStream fileOut = new FileOutputStream("./Cp19_SerializationBasicData.out");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objOut);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
