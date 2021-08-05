package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReceiver implements Runnable {
  private Socket socket;
  private BufferedReader input;

  public ClientReceiver(Socket _socket) throws Exception {
    this.socket = _socket;
    this.input = new BufferedReader(new InputStreamReader(_socket.getInputStream()));
    String message = input.readLine();
    System.out.println(message);
  }

  @Override
  public void run() {
    while (!this.socket.isClosed()) {
      try {
        String message = this.input.readLine();
        if (message == null) {
          System.out.println("Server stopped");
          break;
        }
        System.out.println(message);
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }

}
