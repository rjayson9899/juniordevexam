import java.util.Scanner;

public class Store {
    public static void main(String[] args) {
        //initializations
        Scanner input = new Scanner(System.in);
        int choice1 = 0, choice2 = 0 , quantity = 0;
        Product pen = new Product("Pen", 10, 5);
        Product pencil = new Product("Pencil", 20, 2);
        Product notebook = new Product("Notebook", 10, 8);
        Product eraser = new Product("Eraser", 30, 2);

        do{
            System.out.println("\033[H\033[2J");
            //System.out.flush();

            System.out.println("Welcome to your POS system!");
            System.out.println("---------------------------");
            System.out.println("        Main Menu          ");
            System.out.println("---------------------------");
            System.out.println("1 - Display Inventory");
            System.out.println("2 - Add Product Quantity");
            System.out.println("3 - Enter Sales Transaction");
            System.out.println("4 - Display All Sales Transactions");
            System.out.println("0 - Exit");
            System.out.println("-------------------------- ");
            System.out.print("Your decision: ");
            choice1 = input.nextInt();

            switch(choice1){

                case 1:
                    pen.displayInv();
                    pencil.displayInv();
                    notebook.displayInv();
                    eraser.displayInv();
                    break;

                case 2:
                    System.out.print("which product would you like to add? :");
                    System.out.println("1 - Pen");
                    System.out.println("2 - Pencil");
                    System.out.println("3 - Notebook");
                    System.out.println("4 - Eraser");
                    choice2 = input.nextInt();

                    System.out.print("How many would you like to add? : ");
                    quantity = input.nextInt();

                    switch(choice2){

                        case 1:
                            pen.addQuantity(quantity);
                            break;
                        
                        case 2:
                            pencil.addQuantity(quantity);
                            break;
                        
                        case 3:
                            notebook.addQuantity(quantity);
                            break;
                        
                        case 4:
                            notebook.addQuantity(quantity);
                            break;
                        }

                    break;
            
                case 3:

                    System.out.print("which product would you like to sell? :");
                    System.out.println("1 - Pen");
                    System.out.println("2 - Pencil");
                    System.out.println("3 - Notebook");
                    System.out.println("4 - Eraser");
                    choice2 = input.nextInt();

                    System.out.print("How many would you like to sell? : ");
                    quantity = input.nextInt();

                    switch(choice2){

                        case 1:
                            pen.sellProduct(quantity);
                            break;
                        
                        case 2:
                            pencil.sellProduct(quantity);
                            break;
                        
                        case 3:
                            notebook.sellProduct(quantity);
                            break;
                        
                        case 4:
                            notebook.sellProduct(quantity);
                            break;
                        }

                break;

            case 4:
                System.out.format("%-10s %-10s %-10s","Name","Sold", "Sales");
                System.out.format("%-10s %-10s %-10s",pen.getName(),pen.getSold(), pen.getSale());
                System.out.format("%-10s %-10s %-10s",pencil.getName(),pencil.getSold(), pencil.getSale());
                System.out.format("%-10s %-10s %-10s",notebook.getName(),notebook.getSold(), notebook.getSale());
                System.out.format("%-10s %-10s %-10s",eraser.getName(),eraser.getSold(), eraser.getSale());
                break;
            
            case 0:
                System.exit(0);

            }
        }while(choice1 != 0);

        input.close();
    }
}