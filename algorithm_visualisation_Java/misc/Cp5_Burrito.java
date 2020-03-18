public class Cp5_Burrito{
    Spiciness degree;
    public Cp5_Burrito (Spiciness degree){this.degree = degree;}
    public void describe(){
	switch (degree){
	case NOT:
	case MILD:
	case MediUM: System.out.println("below Medium");
	    break;
	case HOT:
	case FLAMING: System.out.println("Somehow Hot");
	    break;
	}
    }
    public static void main(String[] args){
	Cp5_Burrito
	    plain = new Cp5_Burrito(Spiciness.NOT),
	    chill = new Cp5_Burrito(Spiciness.HOT);
	plain.describe();
	chill.describe();
    }
}
