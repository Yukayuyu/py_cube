import java.util.*;

public class Cp12_Foreach {
    class ForEachCollections {
        void run() {
            Collection<String> cs = new LinkedList<String>();
            Collections.addAll(cs, "Take me to the moon".split(" "));
            for (String s : cs)
                System.out.println(s + " ");
        }

    }
    class IterableClass implements Iterable<String> {
        protected String[] words = ("fly me to the moon".split(" "));

        public Iterator<String> iterator() {
            return new Iterator<String>() {
                private int index = 0;

                public boolean hasNext() {
                    return index < words.length;
                }

                public String next() {
                    return words[index++];
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };

        }

        void run() {
            for (String s : new IterableClass())
                System.out.println(s + " ");
        }

    }

    public static void main(String[] args) {
        Cp12_Foreach x = new Cp12_Foreach();
        ForEachCollections xx = x.new ForEachCollections();
        IterableClass xy = x.new IterableClass();
        xx.run();
        System.out.println();
        xy.run();
    }
}
