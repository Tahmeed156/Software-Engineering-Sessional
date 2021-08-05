package components.weight;

class WeightModule implements WeightSensorInterface {
  
  WeightModule() {
    System.out.println("WeightModule created");
  }

  @Override
  public float measure() {
    float weight = (float) 4.5;
    System.out.println("Weight scanned successfully: " + weight);
    return weight;
  }
  
}
