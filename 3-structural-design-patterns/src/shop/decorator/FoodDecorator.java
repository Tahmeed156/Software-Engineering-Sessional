package decorator;

import component.FoodComponent;

public class FoodDecorator implements FoodComponent {

  protected FoodComponent food;

  FoodDecorator(FoodComponent _food) {
    this.food = _food;
  }

  @Override
  public float getPrice() {
    return this.food.getPrice();
  }
  
}
