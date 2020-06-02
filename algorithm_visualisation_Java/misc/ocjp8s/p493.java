package ocjp8s;

@SuppressWarnings("all")
class p493 {
    public static void main(String[] args) {
        int[] arr;
        // ! arr={1,2}; // Array constants can only be used in initializer
        int[] array = {2, 3, 4};
        int[] array2 = array.clone();
        array2[0] = 5;
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("----------------");
        int[] array3;
        array3 = array;
        array3[0] = 5;
        for (int i : array3) {
            System.out.println(i);
        }
    }
}
