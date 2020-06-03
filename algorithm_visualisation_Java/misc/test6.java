class test6 {
    public static void main(String[] args) {
        int i = 1;
        try {
            i = 3;
        } finally {
            System.out.println(i);
        }
        System.out.println(i);
    }
}
