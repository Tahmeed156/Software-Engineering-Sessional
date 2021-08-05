import factory.*;
import parser.ParserInterface;
import aesthetic.AestheticsInterface;

public class Editor {

  private static Editor instance;
  private ParserInterface parser;
  private AestheticsInterface aesthetics;

  private Editor(String fileExtension) throws Exception {

    AbstractFactory factory = null;
    
    switch(fileExtension) {
      case "py":
        factory = new PythonFactory();
        break;
      case "c":
        factory = new CFactory();
        break;
      case "cpp":
        factory = new CppFactory();
        break;
      default:
        throw new Exception("ERROR: no support for extension " + fileExtension);
    }

    this.parser = factory.getParser();
    this.aesthetics = factory.getAesthetics();
  }
  
  public static void openFile(String fileName) throws Exception {
    if (instance != null) {
      System.out.println("Closing previous file");
      closeFile();
    }
    
    String fileExtension = fileName.split("\\.")[1];
    instance = new Editor(fileExtension);
  }

  public static void closeFile() {
    instance = null;
  }

}