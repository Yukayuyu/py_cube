class Cp5_ThisC{
    private int i = 0;
    Cp5_ThisC  increment (){
	i++;
    return this;
    }
    int getter(){
	return i;
    }
}
public class Cp5_This{
    public static void main(String[] args){
	Cp5_ThisC x = new Cp5_ThisC(); 
	int j = x.increment().increment().increment().getter();
	System.out.println(j);
    }
}
