public class Cp0_SystemProperties {
    public static void main(String[] args) {
        System.setProperty("testP", "value");
        String s = System.getProperty("testP");
        System.out.println(s);

    }
    
}
