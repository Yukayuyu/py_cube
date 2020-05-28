import java.util.*;

class Cp12_Snow {
}


class Cp12_Powder extends Cp12_Snow {
}


class Cp12_Light extends Cp12_Powder {
}


class Cp12_Heavy extends Cp12_Powder {
}


class Cp12_Crusty extends Cp12_Snow {
}


public class Cp12_AsListInference {
    public static void main(String[] args) {
        List<Cp12_Snow> snow1 = Arrays.asList(new Cp12_Crusty(), new Cp12_Powder());
        List<Cp12_Snow> snow4 = Arrays.asList(new Cp12_Light(), new Cp12_Heavy());
        // Maybe won't compile, (depends on JDK?)
        // found: java.util.List<Powder> required:
        // java.util.List<Snow>
        List<Cp12_Snow> snow2 = Arrays.<Cp12_Snow>asList( // explicit type argument specification
                new Cp12_Light());
        List<Cp12_Snow> snow3 = new ArrayList<Cp12_Snow>();
        Collections.addAll(snow3, new Cp12_Light(), new Cp12_Heavy()); // doesn't get confused
        // Collections.addAll check the type of the first element, and add others into it.
        System.out.println(snow1);
        System.out.println(snow2);
        System.out.println(snow3);
        System.out.println(snow4);
    }
}
