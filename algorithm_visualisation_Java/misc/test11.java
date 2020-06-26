import java.util.*;
public class test11{
    public static void main(String[] args) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("admin", "pw");
        String uID ="admin";
        if (userMap.containsKey(uID)) {
            System.out.println(userMap.get(uID));
    }
}
}
