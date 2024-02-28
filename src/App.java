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
    FileHandler fileHandler = new FileHandler(); 
    ShoppingCart userCart = new ShoppingCart();

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
            if (fileHandler.userHasDB()) {
              //!TODO Load DB
              isLoggedIn = true;
            } 
            break;
          case "add":
            userCart.add(userPrompts);
            break;
          case "remove":
            userCart.remove(Integer.valueOf(userPrompts.get(0)));
            break;
          case "list":
            userCart.list();
            break;
          case "save":
            if (isLoggedIn) {
              // save
            } else {
              System.out.println("Please login first, before saving!");
            }
          default:
            break;
        }        
      }

    }
  }
}
