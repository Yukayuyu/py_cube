enum Cp22_EnumBasicEnum {
    HIGH, normal, LOW, RED("reder than blue"), Blue("bluer than green"), Green("greener than red");

    public String description;

    Cp22_EnumBasicEnum() {}

    Cp22_EnumBasicEnum(String description) {
        this.description = description;
        System.out.println(description);
    }
}


public class Cp22_EnumBasic {
    public static void main(String[] args) {
        for (Cp22_EnumBasicEnum e : Cp22_EnumBasicEnum.values()) {
            System.out.print(e + " ");
            System.out.print(e.compareTo(Cp22_EnumBasicEnum.normal) + " ");
            System.out.print((e == Cp22_EnumBasicEnum.normal) + " ");
            System.out.print(e.getDeclaringClass() + " ");
            System.out.println(e.name() + " ");
            System.out.println("--------------------------------");
        }
    }
}
