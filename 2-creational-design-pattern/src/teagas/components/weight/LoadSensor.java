package components.weight;

class LoadSensor implements WeightSensorInterface {
    
  LoadSensor() {
    System.out.println("LoadSensor created");
  }

  @Override
  public float measure() {
    float weight = (float) 4.5;
    System.out.println("Weight scanned successfully: " + weight);
    return weight;
  }

}
