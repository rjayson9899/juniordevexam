import java.util.Scanner;
import java.text.NumberFormat;

public class Store {
    public static void main(String[] args) {
        String[] productNames = {"Pen", "Pencil", "Notebook", "Eraser"};
        double[] price = {5.0, 2.0, 8.0, 2.0};
        int[] initialStock = {10, 20, 10, 30};
        Scanner in = new Scanner(System.in);
        NumberFormat money = NumberFormat.getCurrencyInstance();
        Product[] inventory = new Product[productNames.length];
        int op;


        for (int i = 0; i < productNames.length; i++) {
            inventory[i] = new Product(productNames[i], initialStock[i], price[i])
        }

        do {
            System.out.println("Current Inventory");
            System.out.format("%20s\t%20s\t%20s", "Product", "Stock", "Price");
            for (int i = 0; i < productNames.length; i++) {
                System.out.format("%20s\t%20s\t%20s", inventory[i].getName(), inventory[i].get);
            }
        } while(op != 0);
    }
}