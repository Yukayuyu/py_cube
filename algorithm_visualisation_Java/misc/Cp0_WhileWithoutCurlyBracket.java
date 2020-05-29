class Cp0_WhileWithoutCurlyBracket {
    public static void main(String[] args) {
        int i = 0;
        while (i++ < 3)
            // !while (i < 3, i++)
            while (true)
                break;
        // ! break; // not nestable
    }
}
