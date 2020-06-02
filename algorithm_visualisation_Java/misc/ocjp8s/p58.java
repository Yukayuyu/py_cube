package ocjp8s;

@SuppressWarnings("all")
class p58Sample {
    private int num;
    private String name;

    public p58Sample(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof p58Sample) {
            p58Sample s = (p58Sample) obj;
            return s.num == this.num; // equals() is in class p58Sample
                                      // Hence private s.num can be accessed.
                                      // even in a.equals();
        }
        return false;
    }
}


public class p58 {
    public static void main(String[] args) {
        p58Sample a = new p58Sample(10, "a");
        p58Sample b = new p58Sample(10, "b");
        System.out.println(a.equals(b));
    }
}
