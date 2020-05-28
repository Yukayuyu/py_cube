import java.util.*;
class Snow {}
class Powder extends Snow {}
class Light extends Powder {}
class Heavy extends Powder {}
class Crusty extends Snow {}

@SuppressWarnings("all")
public class AsListInference {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(
            new Crusty(), new Powder());
        //! List<Snow> snow2 = Arrays.asList(
        //!    new Light()); //won't compile, found: java.util.List<Powder> required: java.util.List<Snow>
        List<Snow> snow2 = Arrays.<Snow>asList( //explicit type argument specification
            new Light());
        List<Snow> snow3 = new ArrayList<Snow>(); 
        Collections.addAll(snow3, new Light(), new Heavy()); //doesn't get confused
        //Collections.addAll check the type of the first element, and add others into it.
        System.out.println(snow3);
    }
}