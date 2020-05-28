import java.util.*;

@SuppressWarnings("all")
class Cp12_ReversibleArrayList<T> extends ArrayList<T> {
    public Cp12_ReversibleArrayList() {
        super();

    }

    public Cp12_ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversed() { // A method;
        return new Iterable<T>() {
            public Iterator<T> iterator() { // A method;
                return new Iterator<T>() {
                    int current = size() - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<T> reversed2() {

        class revIterable implements Iterable<T> {
            public Iterator<T> iterator() {
                class x implements Iterator<T> {// a class inside a method is a local class.
                    int current = size() - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                }
                return new x();
            }
        }
        return new revIterable();
    }
}


public class Cp12_Reversible {
    public static void main(String[] args) {
        Cp12_ReversibleArrayList<String> ral =
                new Cp12_ReversibleArrayList<String>(Arrays.asList("a b c".split(" ")));
        Cp12_ReversibleArrayList<String> ral2 = new Cp12_ReversibleArrayList<String>();
        String[] s1 = ("fly me to the moon".split(" "));
        Collections.addAll(ral2, s1);
        for (String s : ral.reversed())
            System.out.print(s + " ");
        System.out.println();
        for (String s : ral.reversed2())
            System.out.print(s + " ");

        System.out.println();
    }
}
