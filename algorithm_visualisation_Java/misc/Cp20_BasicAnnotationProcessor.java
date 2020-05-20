import java.lang.reflect.Method;
import java.util.*;

public class Cp20_BasicAnnotationProcessor {
    public static void trackCustomAnnotation(List<Integer> useCaseID, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            Cp20_BasicAnnotationDefine bad = m.getAnnotation(Cp20_BasicAnnotationDefine.class);
            if (bad != null) {
                System.out.println("Found useCase, ID = " + bad.ID() + " reviewed by "
                        + Arrays.toString(bad.reviewers()));
                Object o = bad.ID();
                useCaseID.remove(o);
            }
        }

        for (int i : useCaseID) {
            System.out.println("Warning: Missing useCase: " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCaseID = new ArrayList<Integer>();
        Collections.addAll(useCaseID, 11, 02, 03);
        trackCustomAnnotation(useCaseID, Cp20_BasicAnnotationRun.class);
    }
}
