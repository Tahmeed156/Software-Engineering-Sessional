package sum;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class AsciiSum implements SumInterface {

  private IntegerSum instance;

  public AsciiSum(IntegerSum _instance) {
    this.instance = _instance;
  }

  public void calculateSum(String fileName) throws Exception {
    File inFile = new File(fileName);
    File outFile = new File("tempIntegerToAscii.txt"); // temporary file
    int num = 0;

    Scanner sc = new Scanner(inFile);
    Writer wr = new FileWriter(outFile);
    
    // convert characters to ascii, store temporarily
    while (sc.hasNext()) {
      num = sc.next().charAt(0);
      wr.write(String.valueOf(num));
      wr.write(" ");
    }

    sc.close();
    wr.close();

    // call integer sum on ascii file
    this.instance.calculateSum("tempIntegerToAscii.txt");

    outFile.delete();
  }
  
}
