class Cp0_LegalToThrowIfGuarded {
    public static void main(String[] args) {
        // ! throw new Exception(); // unhandled.
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // legal if catched.
    }
}
