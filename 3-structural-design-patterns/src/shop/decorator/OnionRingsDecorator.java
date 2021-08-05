package decorator;

import component.FoodComponent;

public class OnionRingsDecorator extends FoodDecorator {
      
  public OnionRingsDecorator(FoodComponent _food) {
    super(_food);
  }

  @Override
  public float getPrice() {
    return super.getPrice() + 100;
  }

}
