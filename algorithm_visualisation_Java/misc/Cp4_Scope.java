/*
 * //The private is illegal (outside a public class)
 * 
 * @SuppressWarnings("all")
 * 
 * @SuppressWarnings("all")
 * 
 * @SuppressWarnings("all") private class Data01{ static int constI = 1; }
 */
// import static must follows a static method

// The code might be confusing, more explaination in the note.
import java.util.Random;

// import java.util.*;
public class Cp4_Scope {
    private static class Data01 {
        static int constI = 1;
    }
    private class Data02 {
        static final int constI = 1;
    }
    @SuppressWarnings("all")
    private class Random04 {
        Random rand04 = new Random();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {
        // Data01 D = Data01();i
        System.out.println(Data01.constI);
        System.out.println(Data02.constI);
        Data01.constI++;
        // Data02.constI++; illegal since final
        System.out.println(Data01.constI);
        System.out.println(Data02.constI);
        ////////////////////
        Random rand03 = new Random();
        int rand03_int1 = rand03.nextInt();
        // int i = rand04.nextInt();
    }
}
