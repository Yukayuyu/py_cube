interface Selector {
    boolean end();

    Object current();

    void next();
}


public class Cp11_Selector { // It is actually a Sequence and Sequence generator.
    private Object[] items;
    private int next = 0;

    public Cp11_Selector(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class theSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    public theSelector selector() {
        return new theSelector();
    }

    public static void main(String[] args) {
        Cp11_Selector sequence = new Cp11_Selector(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        theSelector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
