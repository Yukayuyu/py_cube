package ocjp8s;

public class p100 {
    public static void main(String[] args) {
        int[][] arrA = {{1, 2}, {3, 4}};
        int[][] arrC = new int[2][];
        System.arraycopy(arrA, 0, arrC, 0, 1);
        int[][] arrB = arrA.clone();
        arrA[0][0] = 11;
        System.out.println(arrB[0][0]);
        System.out.println(arrC[0][0]);// only reference is copied, since only the 1st level is
                                       // copied.
    }
}
