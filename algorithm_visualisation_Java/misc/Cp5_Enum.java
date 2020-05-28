public class Cp5_Enum{
    public enum Spiciness{
	NOT, MILD, MediUM, HOT, FLAMING
    }
@SuppressWarnings("all")
    public static void main (String[] args){
	Spiciness howHOT = Spiciness.MediUM;
	System.out.println(howHOT + "ordinal" + howHOT.ordinal() + howHOT.toString());
	Integer
	    i = new Integer(1),
	    j = new Integer(2);
	System.out.println(" " + i + j);
    }
}
