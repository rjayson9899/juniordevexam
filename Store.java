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
        int oper, prodId, amount;

        for (int i = 0; i < productNames.length; i++) {
            inventory[i] = new Product(productNames[i], initialStock[i], price[i]);
        }

        do {
            System.out.print("\033[H\033[2J");  
            //System.out.flush();

            System.out.println("Welcome to your POS system!");
            System.out.println("---------------------------");
            System.out.println("        Main Menu          ");
            System.out.println("---------------------------");
            System.out.println("1 - Display Inventory");
            System.out.println("2 - Add stock to product");
            System.out.println("3 - Enter Sales Transaction");
            System.out.println("4 - Display All Sales Transactions");
            System.out.println("0 - Exit");
            System.out.println("-------------------------- ");
            System.out.print("Your decision: ");
            oper = in.nextInt();
            in.nextLine();

            System.out.println();
            switch (oper) {
                case 1:
                    System.out.println("Current Inventory: ");
                    System.out.format("%-20s\t%20s\t%20s\n", "Product", "Stock", "Price");
                    for (int i = 0; i < productNames.length; i++) {
                        inventory[i].displayInv();
                    }
                    break;
                case 2:
                    for (int i = 0; i < productNames.length; i++) {
                        System.out.format("%-2s. %-10s - %6s\n", (i + 1), inventory[i].getName(), inventory[i].getStock());
                    }

                    System.out.print("Enter product number to increase quantity: ");
                    prodId = (in.nextInt() - 1);
                    in.nextLine();

                    if (prodId > productNames.length || prodId < 0) {
                        System.out.println("Invalid input, returning to main menu...");
                    }
                    else {
                        System.out.print("Enter quantity of " + inventory[prodId].getName() + " to increase by: ");
                        amount = in.nextInt();
                        in.nextLine();
                        
                        if (amount > 0) {
                            inventory[prodId].addStock(amount);
                        } 
                        else {
                            System.out.println("Invalid input, returning to main menu...");
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < productNames.length; i++) {
                        System.out.format("%-2s. %-10s - %6s\n", (i + 1), inventory[i].getName(), inventory[i].getStock());
                    }

                    System.out.print("Enter product number to product to buy: ");
                    prodId = (in.nextInt() - 1);
                    in.nextLine();

                    if (prodId > productNames.length || prodId < 0) {
                        System.out.println("Invalid input, returning to main menu...");
                    }
                    else {
                        System.out.print("Enter quantity of " + inventory[prodId].getName() + " to buy: ");
                        amount = in.nextInt();
                        in.nextLine();
                        
                        if (amount > inventory[prodId].getStock()) {
                            System.out.println("Invalid input. Input must be less than or equal to current stock. Returning to main menu...");
                        } 
                        else if (amount < 0) {
                            System.out.println("Invalid input, returning to main menu...");
                        }
                        else {
                            inventory[prodId].sellProduct(amount);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Current Inventory");
                    System.out.format("%-20s\t%-20s\t%-20s\n", "Product", "Amount Sold", "Revenue");
                    for (int i = 0; i < productNames.length; i++) {
                        System.out.format("%-20s\t%-20s\t%-20s\n", inventory[i].getName(), inventory[i].getSold(),
                            money.format(inventory[i].getSale()));
                    }
                    break;
                case 0:
                    System.out.println("exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("\nPress enter to continue...");
            in.nextLine();
        } while(oper != 0);

        in.close();
    }
}