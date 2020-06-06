enum Cp22_EnumBasicEnum {
    HIGH, normal, LOW, misc;
}


public class Cp22_EnumBasic {
    public static void main(String[] args) {
        for (Cp22_EnumBasicEnum e : Cp22_EnumBasicEnum.values()) {
            System.out.println(e);
            System.out.println(e.compareTo(Cp22_EnumBasicEnum.normal));
            System.out.println(e == Cp22_EnumBasicEnum.normal);
            System.out.println(e.getDeclaringClass());
            System.out.println(e.name());
            System.out.println("--------------------------------");
        }
    }
}
