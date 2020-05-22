class Cp0_FieldBehaviorWhenInheritanceBase {
    int fieldI = 1;
}


public class Cp0_FieldBehaviorWhenInheritance extends Cp0_FieldBehaviorWhenInheritanceBase {
    Cp0_FieldBehaviorWhenInheritance() {
        System.out.println("original super.fieldI= " + super.fieldI);
        fieldI = 10;
    }

    int getSuperI() {
        return super.fieldI;
    }

    public static void main(String[] args) {
        Cp0_FieldBehaviorWhenInheritance x = new Cp0_FieldBehaviorWhenInheritance();
        System.out.println(x.fieldI);
        System.out.println(x.getSuperI());
        // without shadowing, the child and parent seems to share a same field namespace.
    }
}
