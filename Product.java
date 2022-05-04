import java.text.NumberFormat;

public class Product {
    private String name;
    private int quantity;
    private double price;
    private int sold;

    /*
     * Constructor
     */
    public Product (String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.sold = 0;
    }

    /*
     * Code to display inventory
     */
    public void displayInv() {
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.format("%-20s\t%20s\t%20s\n", this.name, this.quantity, money.format(this.price));
    }

    /*
     * Code to add quantity of inventory
     */
    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    /*
     * Deducts quantity based on input amount
     * returns final price based on amount of
     * goods sold
     */
    public double sellProduct(int amount) {
        double price = this.price;
        this.quantity -= amount;
        price *= quantity;
        this.sold += amount;

        return price;
    }

    /*
     * Fetch the name of the product
     * as output
     */
    public String getName() {
       return this.name; 
    }

    /*
     * Fetch the current amount of
     * quantity as output
     */
    public int getStock() {
       return this.quantity;
    }

    /*
     * Fetch the current price of
     * Product as output
     */
    public double getPrice() {
       return this.price; 
    }

    /*
     * Fetch the total amount of
     * goods sold as output
     */
    public int getSold() {
        return this.sold;
    }

    /*
     * Computes for the total sales
     * of the product based on the 
     * amount sold and price
     */
    public double getSale() {
        double sold = this.sold;
        sold *= price;
        return sold;
    }
}