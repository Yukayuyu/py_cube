@FunctionalInterface
interface Cp0_PolymorphismOverMultipleInterfaceFunctionalInterface {

    void execute();
}


interface Cp0_PolymorphismOverMultipleInterfaceBiggerInterface
        extends Cp0_PolymorphismOverMultipleInterfaceFunctionalInterface {
    void anotherMethod();
}


class Cp0_PolymorphismOverMultipleInterfaceTmpClass
        implements Cp0_PolymorphismOverMultipleInterfaceBiggerInterface {
    public void anotherMethod() {
        System.out.println("anotherMethod");
    }

    public void execute() {
        System.out.println("execute");
    }
}


public class Cp0_PolymorphismOverMultipleInterface {
    public static void main(String[] args) {
        // polyInterface over super super interface is possible However ExecutorService cannot be
        // converted to Executor
        Cp0_PolymorphismOverMultipleInterfaceFunctionalInterface x =
                new Cp0_PolymorphismOverMultipleInterfaceTmpClass();
        x.execute();
    }
}
