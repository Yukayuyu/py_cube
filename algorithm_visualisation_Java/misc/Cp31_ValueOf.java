class Cp31_ValueOf {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        System.out.println(Boolean.valueOf("true"));
        System.out.println(Boolean.valueOf("tRue"));
        System.out.println(Boolean.valueOf("what"));
        System.out.println(Boolean.valueOf(null));
        // Returns a Boolean with a value represented by the specified string. The Boolean returned
        // represents a true value if the string argument is not null and is equal, ignoring case,
        // to the string "true".
        System.out.println("------------------------------------------------------------------");
        System.out.println(Integer.valueOf("-3"));
        try {
            System.out.println(Integer.valueOf("F"));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        }
        // Returns an Integer object holding the value of the specified String. The argument is
        // interpreted as representing a signed decimal integer, exactly as if the argument were
        // given to the parseInt(java.lang.String) method. The result is an Integer object that
        // represents the integer value specified by the string.
        // is same as:
        System.out.println(new Integer(Integer.parseInt("-3")));
        System.out.println("------------------------------------------------------------------");
    }
}
