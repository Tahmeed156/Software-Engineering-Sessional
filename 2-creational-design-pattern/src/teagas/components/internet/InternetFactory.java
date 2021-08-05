package components.internet;

public class InternetFactory {
  
  public static InternetInterface create(String _internetType) throws Exception {
    
    switch(_internetType) {
      case "Wifi":
        return new Wifi();
      case "GSM":
        return new GSM();
      case "Ethernet":
        return new Ethernet();
      default:
        throw new Exception("ERROR: Invalid internet type");
    }
  }
  
}
