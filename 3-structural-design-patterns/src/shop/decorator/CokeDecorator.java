package decorator;

import component.FoodComponent;

public class CokeDecorator extends FoodDecorator {
    
  public CokeDecorator(FoodComponent _food) {
    super(_food);
  }

  @Override
  public float getPrice() {
    return super.getPrice() + 30;
  }

}
