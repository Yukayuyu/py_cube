public class Cp11_AnonymousInner {
    int j = 20;

    public Object contents() {
        return new Object() {
            private int i = 11;

            public int value() {
                return i;
            }

            public void whosyourdaddy() {}
        };
    }

    public static void main(String[] args) {
        Cp11_AnonymousInner x = new Cp11_AnonymousInner();
        Object c = x.contents();
    }
}
