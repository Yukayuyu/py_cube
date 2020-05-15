public class test2 {
    static void plus(Integer i) {
        i = i + 10;
        System.out.println("Method i : " + i + " from class: " + i.getClass());
    }

    public static void main(String[] args) {
        Integer i = 999999000;
        plus(i);
        System.out.println("Main:" + i);
    }

}
