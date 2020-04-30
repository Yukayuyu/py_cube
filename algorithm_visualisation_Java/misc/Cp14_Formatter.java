import java.util.*;

public class Cp14_Formatter {
    private Formatter f = new Formatter(System.out);
    private double total = 0;

    public void title() {
        f.format("%-10s %5s %10s\n", "Item", "Qty", "Price");
        f.format("%-10s %5s %10s\n", "----", "---", "-----");
    }

    public void addContent(String name, int qty, double price) {
        f.format("%-10.10s %5s %,10.2f\n", name, qty, price);
        total += price;
    }

    public void total() {
        double tax = total * 0.08;
        f.format("%-10s %5s %0,10.2f\n", "Tax", "", tax); // %,010.2f 0 is a flag means 0 padded.
        f.format("%-10s %5s %20s\n", "", "", "---------------");
        total += tax;
        f.format("%-10.10s %5s %,20.2f\n", "Total", "", total);
    }

    public static void main(String[] args) {
        Cp14_Formatter x = new Cp14_Formatter();
        x.title();
        x.addContent("Pouilly-Jouvet '52", 2, 1799);
        x.addContent("a split of the brut", 1, 15);
        x.total();
    }
}
