@SuppressWarnings("all")
public class Cp5_Initialize{
    int i;
    static int j;
    public static void main (String[] args){
	Cp5_Initialize a = new Cp5_Initialize();
	a.i = 1;
	a.j = 1;
	System.out.println("" + a.i + a.j);
	System.out.println(a.i + a.j + "k"); //different
	Cp5_Initialize b = new Cp5_Initialize();
	b.i = 2;
	b.j = 2;
	System.out.println("" + a.i + a.j); //static is not default.
    }
}
