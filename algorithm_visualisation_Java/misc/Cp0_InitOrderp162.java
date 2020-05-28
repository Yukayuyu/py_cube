@SuppressWarnings("all")
class Cp0_InitOrderp162Sample {
    void Cp0_InitOrderp162Sample() { // this method has a constructor name but still can be compiled
                                     // and called.
        System.out.println("A");
    }

    Cp0_InitOrderp162Sample() {
        System.out.println("Constructor?");
    }

    Cp0_InitOrderp162Sample(int i) {
        this();
        this.Cp0_InitOrderp162Sample();
        System.out.println("Constructor with i");
    }

    {
        System.out.println("Code block1");
    }
    static {
        System.out.println("Static code block");
    }
    {
        System.out.println("Code block2");
    }
}


@SuppressWarnings("all")
public class Cp0_InitOrderp162 {
    public static void main(String[] args) {
        Cp0_InitOrderp162Sample x = new Cp0_InitOrderp162Sample(1);
    }
}
