package Classes;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class InputHandler {
  private String input;
  private String command;
  private Boolean isValid;
  private LinkedList<String> prompts;
  private Set<String> validCommands;

  public InputHandler(String input) {
    this.input = input;
    this.prompts = new LinkedList<>();
    this.validCommands = new LinkedHashSet<String>(){{
      add("login");
      add("add");
      add("list");
      add("save");
      add("remove");
      add("exit");
      add("users");
    }};
    parseInput();
  }

  private void parseInput() {
    Scanner scan = new Scanner(this.input);
    String command = scan.next().trim();
    if (validCommands.contains(command)) {
      this.command = command;
      this.isValid = true;
      while (scan.hasNext()) {
        prompts.add(scan.next().trim().replaceAll("[^a-zA-Z0-9]+",""));
      }
    } else {
      this.isValid = false;
      System.out.println("Invalid command input received, please try again.");
    }
    scan.close();
  }

  public String getCommand() {
    return this.command;
  }

  public LinkedList<String> getPrompts() {
    return this.prompts;
  }

  public String getUser() {
    return this.prompts.get(0);
  }

  public boolean isValid(){
    return this.isValid;
  }
}
