public class Cp11_Shadowing {
    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("Cp11_Shadowing.this.x = " + Cp11_Shadowing.this.x);
        }
    }

    public static void main(String... args) {
        Cp11_Shadowing st = new Cp11_Shadowing();
        Cp11_Shadowing.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }
}
