@SuppressWarnings("all") 
public class Cp14_InfiniteRecursion {
    public String toString(){
        //return " InfiniteRecursion address: " + this + "\n";
        return "haha";
    }

    public static void main(String[] args) {
        Cp14_InfiniteRecursion x = new Cp14_InfiniteRecursion();
        System.out.println(x);
        // InfiniteLoop if "this" is in toString();
    }
}

