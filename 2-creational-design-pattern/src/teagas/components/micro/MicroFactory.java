package components.micro;

public class MicroFactory {
  
  public static MicroInterface create(String _microType) throws Exception {
    
    switch(_microType) {
      case "RaspberryPi":
        return new RaspberryPi();
      case "ATMega32":
        return new ATMega32();
      case "ArduinoMega":
        return new ArduinoMega();
      default:
        throw new Exception("ERROR: Invalid micro controller type");
    }
  }

}
