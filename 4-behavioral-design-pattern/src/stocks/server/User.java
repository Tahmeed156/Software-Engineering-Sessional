package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import subscription.SubscriberInterface;
import subscription.Publisher;
import subscription.Stock;

public class User implements Runnable, SubscriberInterface {
  private Socket socket;
  private BufferedReader input;
  private PrintWriter output;
  private int userId;
  private Publisher publisher;

  public User(Socket _socket, int _userId, Publisher pub) throws Exception {
    this.socket = _socket;
    this.userId = _userId;
    this.publisher = pub;

    // setup input/output
    this.input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
    this.output = new PrintWriter(this.socket.getOutputStream());
    this.output.println("=== Connected: User-" + this.userId + " ===");
    this.output.print(pub.printStocks());
    this.output.flush();
  }

  @Override
  public void run() {
    try {
      while (!this.socket.isClosed()) {
        String command = this.input.readLine();
        if (command == null) {
          System.out.println("User-" + this.userId + " left");
          break;
        }
        System.out.println("User-" + this.userId + ": " + command);

        String[] inpTokens = command.split(" ");
        Stock stock = null;

        switch (inpTokens[0]) {
          case "S":
            stock =  this.publisher.searchStock(inpTokens[1]);
            stock.subscribe(this);
            break;
          case "U":
            stock =  this.publisher.searchStock(inpTokens[1]);
            stock.unsubscribe(this);
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

  @Override
  public void update(String msg) {
    this.output.println(msg);
    this.output.flush();
  }
}
