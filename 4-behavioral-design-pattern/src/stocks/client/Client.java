package client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      Socket connection = new Socket("localhost", 8000);

      // setup output
      PrintWriter output = new PrintWriter(connection.getOutputStream(), true);

      // setup input (separate thread)
      Runnable a = new ClientReceiver(connection);
      Thread t = new Thread(a);
      t.start();

      // setup console input
      Scanner scn = new Scanner(System.in);
      String inp;
  
      // read console and send it to server
      while (scn.hasNextLine()) {
        inp = scn.nextLine();
        output.println(inp);
      }

      scn.close();
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }
}
