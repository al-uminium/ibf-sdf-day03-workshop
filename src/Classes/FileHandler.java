package Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class FileHandler {
  private File dbDir;

  public FileHandler(String dirPath) {
    this.dbDir = new File(dirPath);
    if (!this.dbDir.exists()) {
      this.dbDir.mkdir();
    }
  }
  
  public void listUsers() {
    File[] listOfDB = dbDir.listFiles();
    if (listOfDB.length > 0) {
      System.out.println("The following users are registered:");
      for (int i = 0; i < listOfDB.length; i++) {
        System.out.printf("%d. %s\n", i+1, listOfDB[i].getName().replace(".db", ""));
      }
    } else {
      System.out.println("No users are registered.");
    }
  }

  public boolean userHasDB(String userDB) {
    File[] listOfDB = dbDir.listFiles();
    if (listOfDB.length > 0) {
      for (int i = 0; i < listOfDB.length; i++) {
        if (listOfDB[i].getName().contains(userDB)) {
          return true;
        }
      }
    } 
    return false;
  }

  public void save(LinkedList<String> cart, String userDB) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(dbDir + File.separator + userDB));
      for (String item : cart) {
        writer.write(item + "\n");  
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("An error has occured, printing stack trace.");
      e.printStackTrace();
    }
  }

  public LinkedList<String> load(String userDB) {
    LinkedList<String> cart = new LinkedList<>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(userDB));
      String line = reader.readLine();
      while (line != null) {
        cart.add(line);
        line = reader.readLine();
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found!");
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    return cart;
  }
}
