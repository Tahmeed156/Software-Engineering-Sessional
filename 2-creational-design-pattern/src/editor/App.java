import java.util.Scanner;

public class App {
  
  public static void main (String [] args) {

    Scanner scn = new Scanner(System.in);
    String inp, inpTokens[];

    while (scn.hasNextLine()) {
      inp = scn.nextLine();
      inpTokens = inp.split(" ");

      try {
        Editor.openFile(inpTokens[0]);
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }

    }

    scn.close();

  }
}
