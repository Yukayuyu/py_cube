class Cp15_GetClass {
    public static void main(String[] args) {
        Number n = 0;
        Class<? extends Number> c = n.getClass();
        System.out.println(c);
    }
}
