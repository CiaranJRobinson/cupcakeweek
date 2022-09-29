import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu){
        System.out.println("Hello customer. Would you like to place an order? (Y/N");
        Scanner inputs = new Scanner(System.in);
        String placeOrder = inputs.nextLine();

        ArrayList<Object> order = new ArrayList<Object>();
        if (placeOrder.equalsIgnoreCase("y")){
            LocalDate.now();
            LocalTime.now();
            System.out.println("Here is the menu");
            System.out.println("Cupcakes: ");
            int itemNumber = 0;
            for (int i =0; i < cupcakeMenu.size(); i++){
                itemNumber++;
                System.out.println(itemNumber + ".");
                cupcakeMenu.get(i).type();
                System.out.println("Price: $" + cupcakeMenu.get(i).getPrice());
                System.out.println("\n");
            }
            System.out.println("Drinks: ");
            for (int i = 0; i < drinkMenu.size(); i++){
                itemNumber++;
                System.out.println(itemNumber);
                drinkMenu.get(i).type();
                System.out.println("Price: $"+ drinkMenu.get(i).getPrice());
                System.out.println("\n");
            }
            boolean ordering = true;
            while (ordering = true){
                System.out.println("What would you like to order? Please use the number associated with each item.");
                int orderChoice = inputs.nextInt();
                inputs.nextLine();

                if(orderChoice == 1){
                    order.add(cupcakeMenu.get(0));
                    System.out.println("Item added to order");
                }else if (orderChoice == 2){
                    order.add(cupcakeMenu.get(1));
                    System.out.println("Item added to order");
                }else if (orderChoice == 3){
                    order.add(cupcakeMenu.get(2));
                    System.out.println("Item added to order");
                }else if (orderChoice == 4){
                    order.add(cupcakeMenu.get(3));
                    System.out.println("Item added to order");
                }else if (orderChoice == 5){
                    order.add(cupcakeMenu.get(4));
                    System.out.println("Item added to order");
                }else if (orderChoice == 6){
                    order.add(cupcakeMenu.get(5));
                    System.out.println("Item added to order");
                }else{
                    System.out.println("Sorry, we don't seem to have that on the menu");
                }

                System.out.println("Would you like to continue ordering?");
                placeOrder = inputs.nextLine();
                if (placeOrder.equalsIgnoreCase("N")){
                    ordering = false;
                }
            }
            System.out.println(order.get(0));
            System.out.println(order.get(1));
            double subtotal = 0.0;
            for (int i=2; i < order.size(); i++){
                if(order.get(i).equals(cupcakeMenu.get(0))){
                    cupcakeMenu.get(0).type();
                    System.out.println(cupcakeMenu.get(0).getPrice());
                    subtotal = subtotal + cupcakeMenu.get(0).getPrice();
                }else if(order.get(i).equals(cupcakeMenu.get(1))){
                    cupcakeMenu.get(1).type();
                    System.out.println(cupcakeMenu.get(1).getPrice());
                    subtotal = subtotal + cupcakeMenu.get(1).getPrice();
                }else if(order.get(i).equals(cupcakeMenu.get(2))){
                    cupcakeMenu.get(2).type();
                    System.out.println(cupcakeMenu.get(2).getPrice());
                    subtotal = subtotal + cupcakeMenu.get(2).getPrice();
                }else if(order.get(i).equals(drinkMenu.get(0))){
                    drinkMenu.get(0).type();
                    System.out.println(drinkMenu.get(0).getPrice());
                    subtotal = subtotal + drinkMenu.get(0).getPrice();
                }else if (order.get(i).equals(drinkMenu.get(1))){
                    drinkMenu.get(1).type();
                    System.out.println(drinkMenu.get(1).getPrice());
                    subtotal = subtotal + drinkMenu.get(1).getPrice();
                }else if (order.get(i).equals(drinkMenu.get(2))){
                    drinkMenu.get(2).type();
                    System.out.println(drinkMenu.get(2).getPrice());
                    subtotal = subtotal + drinkMenu.get(2).getPrice();
                }
            }
            System.out.println("Your total is: $"+ subtotal+ "\n");
            new CreateFile();
            new WriteToFile(order);
        }else {
            System.out.println("Ok, have a nice day!");
        }

    }
}

class CreateFile {
    public CreateFile() {
        try{
            File salesData = new File("salesData.txt");
            if (salesData.createNewFile()){
                System.out.println("File created: " + salesData.getName());
            }else{
                System.out.println("File exists already");
            }
        }catch(IOException e){
            System.out.println("Error");
        }
    }
}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order){
        try{
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);
            for (int i =0; i < order.size(); i++){
                salesWriter.println(order.get(i));
            }
            salesWriter.close();;

            System.out.println("Successfully wrote to the file");

        }catch(IOException e){
            System.out.println("An error occurred");
        }
    }
}
