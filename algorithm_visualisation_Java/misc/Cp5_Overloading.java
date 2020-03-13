class ClassTest{
    int i = 0;
    ClassTest(){ //constructor
	i = 1;
    }
    ClassTest(int j){ //overload constructor
	i = j;
    }
    public void method(){ //method
	double k = i + i;
	System.out.println("i + i = " + k);
    }
    public void method(String str2){ //method1 overload
	double k = i * i;
	System.out.println("i * i = " + k);
    }
}
public class Cp5_Overloading{
    public static void main (String[] args){
	ClassTest a = new ClassTest();
	a.method();
	a.method("rock");
	ClassTest b = new ClassTest(12);
	b.method();
	b.method("rock");
    }
}
