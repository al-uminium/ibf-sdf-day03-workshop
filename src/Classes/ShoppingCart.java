package Classes;

import java.util.LinkedList;

public class ShoppingCart {
  private LinkedList<String> cartArray;

  public ShoppingCart() {
    this.cartArray = new LinkedList<String>();
  }

  public ShoppingCart(LinkedList<String> cart) {
    this.cartArray = cart;
  }
  
  public void add(LinkedList<String> items){
    for (String item : items) {
      if (this.cartArray.contains(item)){
        System.out.printf("%s is in the list already.\n", item);
      } else {
        this.cartArray.add(item);
      }
    }
  }

  public void remove(int index){
    if (index > 0 && index <= this.cartArray.size()){
      this.cartArray.remove(index-1);
    } else {
      System.out.println("This item does not exist in your cart. You can check the index by typing in list.");
    }
  }

  public void list(){
    for (int i = 0; i < this.cartArray.size(); i++) {
      System.out.printf("%d. %s\n", i+1, this.cartArray.get(i));
    }
  }

  public LinkedList<String> getCart() {
    return this.cartArray;
  }

  public Boolean isEmpty() {
    if (this.cartArray.size() > 0) {
      return false;
    }
    return true;
  }
}
