package sum;
import java.io.File;
import java.util.Scanner;

public class IntegerSum {
  
  public void calculateSum(String fileName) throws Exception {
    File file = new File(fileName);
    Scanner sc = new Scanner(file);
    int sum = 0;
    
    while (sc.hasNextInt())
      sum += sc.nextInt();

    System.out.println("Sum: " + sum);
    sc.close();
  }

}
