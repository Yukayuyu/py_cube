package simpleBatis;

public class Main {
    public static void main(String[] args) {
        Entity01UserDAO x = new Entity01UserDAO();
        Entity01User result = x.getUserByID("04"); 
        System.out.println(result);
    } 
}
