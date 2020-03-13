class C{
    private int i = 0;
    C increment (){
	i++;
    return this;
    }
    int getter(){
	return i;
    }
}
public class Cp5_This{
    public static void main(String[] args){
	C x = new C(); 
	int j = x.increment().increment().increment().getter();
	System.out.println(j);
    }
}
