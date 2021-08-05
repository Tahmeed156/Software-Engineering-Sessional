package server;

public class ServerFactory {
  
  public static ServerInterface create(String _serverType) throws Exception {
    
    switch(_serverType) {
      case "Django":
        return new Django();
      case "Laravel":
        return new Laravel();
      case "Spring":
        return new Spring();
      default:
        throw new Exception("ERROR: Invalid server type");
    }
  }
  
}
