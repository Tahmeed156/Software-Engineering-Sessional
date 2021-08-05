package components.controller;

public class ControllerFactory {
      
  public static ControllerInterface create(String _controllerType) throws Exception {
    
    switch(_controllerType) {
      case "Button":
        return new Button();
      default:
        throw new Exception("ERROR: Invalid controller type");
    }
  }

}
