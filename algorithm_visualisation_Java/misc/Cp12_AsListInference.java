import java.util.*;

class Snow {
}


class Powder extends Snow {
}


class Light extends Powder {
}


class Heavy extends Powder {
}


class Crusty extends Snow {
}


public class Cp12_AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(), new Powder());
        List<Snow> snow4 = Arrays.asList(new Light(), new Heavy());
        // Maybe won't compile, (depends on JDK?)
        // found: java.util.List<Powder> required:
        // java.util.List<Snow>
        List<Snow> snow2 = Arrays.<Snow>asList( // explicit type argument specification
                new Light());
        List<Snow> snow3 = new ArrayList<Snow>();
        Collections.addAll(snow3, new Light(), new Heavy()); // doesn't get confused
        // Collections.addAll check the type of the first element, and add others into it.
        System.out.println(snow1);
        System.out.println(snow2);
        System.out.println(snow3);
        System.out.println(snow4);
    }
}
