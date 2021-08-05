package server;

import java.net.Socket;

import subscription.Publisher;

import java.net.ServerSocket;

public class Server {

  public static void main(String[] args) {
    try {
      Publisher pub = new Publisher();

      ServerSocket socket = new ServerSocket(8000);
      System.out.println("=== Server started successfully! ===");
      int userId = 0;

      // connect admin (first user)
      Socket connection = socket.accept();
      Admin a = new Admin(connection, pub);
      Thread t = new Thread(a);
      t.start();
      System.out.println("Admin connected");

      while (true) {
        // new user connected
        connection = socket.accept();
        userId++;
        System.out.println("User-" + userId + " connected");

        // spawn a new thread
        User u = new User(connection, userId, pub);
        t = new Thread(u);
        t.start();
      }
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
