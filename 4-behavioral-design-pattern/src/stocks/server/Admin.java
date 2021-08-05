package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import subscription.Publisher;
import subscription.Stock;

public class Admin implements Runnable {
  private Socket socket;
  private BufferedReader input;
  private PrintWriter output;
  private Publisher publisher;

  public Admin(Socket _socket, Publisher pub) {
    this.socket = _socket;
    this.publisher = pub;
  }

  @Override
  public void run() {
    try {
      // setup input/output
      this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
      this.output = new PrintWriter(this.socket.getOutputStream());
      this.output.println("=== Connected: Admin ===");
      output.flush();

      while (!this.socket.isClosed()) {
        String command = this.input.readLine();
        if (command == null) {
          System.out.println("Admin left");
          break;
        }
        
        System.out.println("Admin: " + command);
        String[] inpTokens = command.split(" ");
        Stock stock = null;

        switch (inpTokens[0]) {
          case "I":
            stock =  this.publisher.searchStock(inpTokens[1]);
            stock.increasePrice(Double.parseDouble(inpTokens[2]));
            break;
          case "D":
            stock =  this.publisher.searchStock(inpTokens[1]);
            stock.decreasePrice(Double.parseDouble(inpTokens[2]));
            break;
          case "C":
            stock =  this.publisher.searchStock(inpTokens[1]);
            stock.changeCount(Integer.parseInt(inpTokens[2]));
            break;
          default:
            System.out.println("ERROR: Invalid command");
        }
      }
    } 
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
