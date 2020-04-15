public class Cp11_AnonymousInner {
    public Wrapping contents() {
        return new Wrapping() {
            private int i = 11;

            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Cp11_AnonymousInner p = new Cp11_AnonymousInner;
        Wrapping c = p.contents();
    }

}
