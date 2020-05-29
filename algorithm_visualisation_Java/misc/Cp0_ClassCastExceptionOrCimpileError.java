@SuppressWarnings("all")
public class Cp0_ClassCastExceptionOrCimpileError {
    public static void main(String[] args) {
        Integer i = 1;
        Integer j = 1;
        long ii = 1L;
        long jj = 1L;
        double d = (double) (i + j);
        System.out.println(d);
        // ! String s = (String) (ii + jj);
        // ! String ss = (String) (i + j);
        // cannot cast to String
    }
}
