package subscription;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Publisher {

  ArrayList<Stock> stocks;
  
  public Publisher() throws Exception {
    this.stocks = new ArrayList<Stock>();
    
    File file = new File("./input.txt");
    Scanner sc = new Scanner(file);
    String[] inpTokens;

    while (sc.hasNextLine()) {
      inpTokens = sc.nextLine().split(" ");
      if (inpTokens.length == 0) break;
      this.stocks.add(new Stock(inpTokens[0], Integer.parseInt(inpTokens[1]), Double.parseDouble(inpTokens[2])));
    }
    // this.stocks.add(new Stock("P1", 3, 40.0));
    // this.stocks.add(new Stock("P2", 4, 30.0));
    // this.stocks.add(new Stock("P3", 5, 80.0));
    // this.stocks.add(new Stock("P4", 6, 25.0));
    // this.stocks.add(new Stock("P5", 7, 15.0));
    // this.stocks.add(new Stock("P6", 9, 50.0));

    sc.close();
  }

  public String printStocks() {
    String result = "";
    for (Stock s: this.stocks) {
      result += s.name + ": " + s.count + " , " + s.price + "\n";
    }
    return result;
  }

  public Stock searchStock(String name) throws Exception {
    name = name.strip();
    for (Stock s: this.stocks) {
      if (s.name.equals(name))
        return s;
    }
    throw new Exception("ERORR: Stock not found by name " + name);
  }

}
