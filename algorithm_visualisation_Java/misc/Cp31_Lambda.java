interface Cp31_LambdaInterface {
    void perform(String name);
}


class Cp31_Service {
    private Cp31_LambdaInterface logic;

    public void setLogic(Cp31_LambdaInterface logic) {
        this.logic = logic;
    }

    public void doProcess(String name) {
        System.out.println("start");;
        this.logic.perform(name);
        System.out.println("end");
    }
}


public class Cp31_Lambda {
    public static void main(String[] args) {
        // Cp31_LambdaInterface algorithm = (name) -> {
        // System.out.println("hello, " + name);
        // };
        Cp31_LambdaInterface algorithm1 = name -> System.out.println("hello, " + name);
        System.out.println("hh"); // Only single line of command is acceptable without curly
                                  // bracket.
        // and the keyward *return* is not allowed in the single line case.
        Cp31_Service s = new Cp31_Service();
        s.setLogic(algorithm1);
        s.doProcess("Lambda1");

        Cp31_LambdaInterface algorithm2 = (name) -> {
            System.out.println("hello2, " + name);
            return; // the return is not ommitable if inside the curly bracket, and if return is
                    // necessary.
        };
        s.setLogic(algorithm2);
        s.doProcess("Lambda1");
    }
}
