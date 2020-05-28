import java.util.*;

class Cp0_FailfastIterator {
    public static void main(String[] args) {
        List<Double> ldd = new ArrayList<Double>(Arrays.asList(1.0, 2d, null));
        ListIterator<Double> li = ldd.listIterator(0);
        ldd.add(3d);
        ldd.remove(2);
        System.out.println(ldd);
        System.out.println(li.hasNext());
    }
}
