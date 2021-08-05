import java.util.Scanner;

import build.Director;
import hardware.HardwareInterface;
import server.ServerInterface;

public class App {

  public static void main (String [] args) {

    Scanner scn = new Scanner(System.in);
    String inp, inpTokens[];
    Director director = null;
    HardwareInterface hardware = null;
    ServerInterface server = null;

    while (scn.hasNextLine()) {
      inp = scn.nextLine();
      inpTokens = inp.split(" ");

      try {
        switch(inpTokens[0]) {
          case "Package":
            director = new Director(inpTokens[1]);
            break;
          case "Build":
            director.buildProduct(inpTokens[1], inpTokens[2]);
            hardware = director.getHardware();
            server = director.getServer();
            break;
          case "Add":
            server.addCollector(inpTokens[1]);
            break;
          case "Remove":
            server.removeCollector(inpTokens[1]);
            break;
          case "Analyze":
            server.analyzeData();
            break;
          case "Scan":
            hardware.scanAndUpload();
            break;
          case "Login":
            System.out.println(inpTokens[1] + " active");
            break;
          default:
            System.out.println("Invalid input. Try again.");
        }
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }

    }

    scn.close();

  }
  
}
