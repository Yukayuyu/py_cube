import chnnn.packageTest.Cp7_Package_Class;

public class Cp7_PackageRun {
    public static void main(String[] args) {
        Cp7_PackageRun x = new Cp7_PackageRun();
        x.methodRun();
        Cp7_Package_Class z = new Cp7_Package_Class();
        z.methodA();
    }

    public void methodRun() {
        Cp7_Package_Class y = new Cp7_Package_Class();
        y.methodA();
    }
}
