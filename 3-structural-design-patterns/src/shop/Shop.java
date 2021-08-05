import decorator.*;

import java.util.Scanner;

import component.*;

public class Shop {

  public static void main (String []args) {
    FoodComponent food;

    Scanner scn = new Scanner(System.in);
    int inp;

    try {
      System.out.println("Please select your pizza!");
      System.out.println("1. Beef pizza: tk.300");
      System.out.println("2. Veggi pizza: tk.200");
      inp = scn.nextInt();

      switch(inp) {
        case 1:
          food = new BeefPizza();
          break;
        case 2:
          food = new VeggiPizza();
          break;
        default:
          throw new Exception("Invalid input. Could not process order!");
      }

      System.out.println("Would you like some appetizers?");
      System.out.println("1. French Fries: tk.100");
      System.out.println("2. Onion Rings: tk.100");
      System.out.println("3. No thanks!");
      inp = scn.nextInt();

      switch(inp) {
        case 1:
          food = new FrenchFriesDecorator(food);
          break;
        case 2:
          food = new OnionRingsDecorator(food);
          break;
        case 3:
          break;
        default:
          throw new Exception("Invalid input. Could not process order!");
      }

      System.out.println("Would you like some drinks?");
      System.out.println("1. Coffee: tk.20");
      System.out.println("2. Coke: tk.30");
      System.out.println("3. No thanks!");
      inp = scn.nextInt();

      switch(inp) {
        case 1:
          food = new CoffeeDecorator(food);
          break;
        case 2:
          food = new CokeDecorator(food);
          break;
        case 3:
          break;
        default:
          throw new Exception("Invalid input. Could not process order!");
      }

      System.out.println("\nTotal price: tk." + food.getPrice());
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    finally {
      scn.close();
    }

  }
  
}
