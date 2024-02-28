import java.io.Console;
import java.util.LinkedList;

import Classes.FileHandler;
import Classes.InputHandler;
import Classes.ShoppingCart;

public class App {
  public static void main(String[] args) {
    // Initializing variables required.
    Boolean isLoggedIn = false;
    Boolean isFinished = false;
    ShoppingCart userCart = new ShoppingCart();
    FileHandler fileHandler = null;
    String userDB = "";
    if (args.length > 0){
      fileHandler = new FileHandler(args[0]); 
    } else {
      fileHandler = new FileHandler("cartdb");
    }

    System.out.println("Welcome to your shopping cart. Login to begin!");
    while (!isFinished) {
      Console cons = System.console();
      String userInput = cons.readLine("> ");

      InputHandler inputHandler = new InputHandler(userInput);
      String userCommand = inputHandler.getCommand();
      LinkedList<String> userPrompts = inputHandler.getPrompts();
      Boolean inputIsValid = inputHandler.isValid();

      if (inputIsValid) {
        switch (userCommand) {
          case "exit":
            isFinished = true;
            break;
          case "login":
            userDB = inputHandler.getUser() + ".db";
            if (fileHandler.userHasDB(userDB)) {
              LinkedList<String> loadedCartList = fileHandler.load(userDB);
              if (!userCart.isEmpty()) {
                System.out.println("Adding your current items into your cart... If items already exist, you will be notified.");
              }
              userCart.add(loadedCartList);
            }
            isLoggedIn = true;
            break;
          case "add":
            userCart.add(userPrompts);
            break;
          case "remove":
            try {
              userCart.remove(Integer.valueOf(userPrompts.get(0)));
            } catch (NumberFormatException e) {
              System.out.println("Invalid format given. You have provided: " + userPrompts.get(0));
            }
            break;
          case "list":
            userCart.list();
            break;
          case "save":
            if (isLoggedIn) {
              if (userCart.isEmpty()) {
                System.out.println("You have no items to save!");
              } else {
                fileHandler.save(userCart.getCart(), userDB);
                System.out.println("Cart has been successfully saved!");
              }
            } else {
              System.out.println("Please login first, before saving!");
            }
            break;
          case "users":
            fileHandler.listUsers();
            break;
          default:
            break;
        }        
      }

    }
  }
}
