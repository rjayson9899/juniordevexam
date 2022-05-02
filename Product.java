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
        this.price = price;//Insert code here
        this.sold = 0;
    }

    /*
     * Code to display inventory
     */
    public void displayInv() {
        System.out.format("%-20s\t%20s\t%20s\n", this.name, this.quantity, this.price);//Insert code here
    }

    /*
     * Code to add quantity of inventory
     */
    public void addQuantity(int amount) {
        this.quantity += amount;//Insert code here
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
       return price;//Insert code here
    }

    /*
     * Fetch the name of the product
     * as output
     */
    public String getName() {
       return this.name; //Insert code here
    }

    /*
     * Fetch the current amount of
     * quantity as output
     */
    public int getStock() {
       return this.quantity; //Insert code here
    }

    /*
     * Fetch the current price of
     * Product as output
     */
    public double getPrice() {
       return this.price; //Insert code here
    }

    /*
     * Fetch the total amount of
     * goods sold as output
     */
    public int getSold() {
        return this.sold;//Insert code here
    }

    /*
     * Computes for the total sales
     * of the product based on the 
     * amount sold and price
     */
    public double getSale() {
        double sold = this.sold;
        sold *= price;
        return sold;//Insert code here
    }
}