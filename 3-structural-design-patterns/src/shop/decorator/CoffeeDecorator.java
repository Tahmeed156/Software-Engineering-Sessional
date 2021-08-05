package decorator;

import component.FoodComponent;

public class CoffeeDecorator extends FoodDecorator {
  
  public CoffeeDecorator(FoodComponent _food) {
    super(_food);
  }

  @Override
  public float getPrice() {
    return super.getPrice() + 20;
  }

}
