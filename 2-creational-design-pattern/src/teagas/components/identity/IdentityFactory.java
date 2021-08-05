package components.identity;

public class IdentityFactory {
  
  public static IdentityInterface create(String _identityType) throws Exception {
    
    switch(_identityType) {
      case "NFC":
        return new NFC();
      case "RFID":
        return new RFID();
      default:
        throw new Exception("ERROR: Invalid identity card type");
    }
  }

}
