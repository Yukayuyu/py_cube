public class Cp0_Array3D {
    void m01() {
        int[] arr02 = new int[2];
        arr02[1] = 3;
        System.out.println((arr02[1]));
        int[][] arr03 = new int[2][2];
        arr03[0][1] = 4;
        arr03[0] = new int[] {2, 2};
        System.out.println((arr03[0][1]));
        System.out.println("--------------------------");
        int[][][] arrDim3 = {{{1, -2, 3}, {2, 3, 4}}, {{-4, 5, 6, 7}, {1}, {-2, 3}}};
        for (int[][] at2D : arrDim3) {
            for (int[] at1D : at2D) {
                for (int i : at1D) {
                    System.out.printf("%d ", i);
                }
                System.out.println();
            }
            System.out.println("+++++");
        }
        System.out.println("--------------------------");
    }

    void m02() {
        Object[][] arr = {{1, 2, 3}, {3, 4, 5, 6, 7}};
        System.out.println(arr.length);
        System.out.println(arr[1].length);
    } // because Object[][] is an array;

    public static void main(String[] args) {
        Cp0_Array3D x = new Cp0_Array3D();
        // x.m01();
        x.m02();
    }
}
