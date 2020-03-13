import javax.swing.*;
public class Interface2{  
    public static void main(String[] args) {  
	String fn = JOptionPane.showInputDialog("text");

	int num1 = Integer.parseInt(fn);

	int sum = num1 * 2;

	JOptionPane.showMessageDialog(null, "The sum is " + sum, "the title", JOptionPane.PLAIN_MESSAE);
    }  
}
