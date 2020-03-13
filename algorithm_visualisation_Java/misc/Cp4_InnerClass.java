public class Cp4_InnerClass {
    String outerStr = "outerStr"; 
    private class Inner_Demo {
	public void print() {
	    System.out.println("InnerDemoPrinting");
	}
    }
    void display_Inner() {
	Inner_Demo x = new Inner_Demo();
        x.print();
    }
    public static void main (String[] args){
	//Non-static variable cannot be referenced from a static context
    }
}
