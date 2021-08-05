package components.display;

public class DisplayFactory {
    
  public static DisplayInterface create(String _displayType) throws Exception {
    
    switch(_displayType) {
      case "TouchScreen":
        return new TouchScreen();
      case "LED":
        return new LED();
      case "LCD":
        return new LCD();
      default:
        throw new Exception("ERROR: Invalid display type");
    }
  }
  
}
