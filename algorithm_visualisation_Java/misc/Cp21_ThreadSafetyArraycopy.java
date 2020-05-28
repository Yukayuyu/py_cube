import java.util.*;

public class Cp21_ThreadSafetyArraycopy {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.arraycopy(array, 2, array, 1, 2);
        System.out.println(Arrays.toString(array));
        int[] array2 = {1, 2, 3, 4, 5, 6, 7};
        System.arraycopy(array2, 0, array2, 1, 4);
        System.out.println(Arrays.toString(array2));
    }
}
