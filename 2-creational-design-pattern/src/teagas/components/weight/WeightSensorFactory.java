package components.weight;

public class WeightSensorFactory {

  public static WeightSensorInterface create(String _weightType) throws Exception {
    
    switch(_weightType) {
      case "WeightModule":
        return new WeightModule();
      case "LoadSensor":
        return new LoadSensor();
      default:
        throw new Exception("ERROR: Invalid weight sensor type");
    }
  }

}
