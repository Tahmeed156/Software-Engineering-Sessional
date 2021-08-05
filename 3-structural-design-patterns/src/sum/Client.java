import sum.AsciiSum;
import sum.IntegerSum;
import sum.SumInterface;

public class Client {

  public static void main (String[] args) {
    try {
      IntegerSum instance = new IntegerSum();
      SumInterface summer = new AsciiSum(instance);

      instance.calculateSum("input1.txt"); // file of integers
      summer.calculateSum("input2.txt"); // file of characters
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

}