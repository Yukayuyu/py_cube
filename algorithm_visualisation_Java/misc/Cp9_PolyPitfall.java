class Super {
    public int i = 0;
    public int getI(){return i;}
}
class Sub extends Super{
    public int i = 1;
    public int getI(){return i;}
    public int getSuperI(){return super.i;}
}
public class Cp9_PolyPitfall{
    public static void main (String[] args){
	Super sup = new Sub();
	System.out.println("sup.i " + sup.i + " sup.getI()" + sup.getI());
    }
}
