@SuppressWarnings("all")
class Cp0_NullString {
    static String s;

    public static void main(String[] args) {
        String s1;
        // ! System.out.println(s1);

        // call s1 gets compile error.
        // since not initialized.
        try {

            System.out.println(s.length()); // null pointer
            System.out.println(s.isEmpty()); // null pointer
        } catch (NullPointerException e) {
            System.out.println("isEmpty() calls length(), nullPointer");
        }

        try {
            s.concat("abc");
        } catch (NullPointerException e) {
            System.out.println("strObj.concat(), nullPointer");
        }
        char[] ch = {'a', 'b', 'c'};
        String s2 = String.valueOf(ch, 1, 2); // char[] data, int offset, int count
        System.out.println(s2);

        System.out.println(String.valueOf(s));
        try {
            System.out.println(String.valueOf(null));
        } catch (NullPointerException e) {
            System.out.println("Stirng.valueOf(null), nullPointer");
        }

    }
}
