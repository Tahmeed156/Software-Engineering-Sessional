package components.display;

import components.controller.ControllerInterface;

class TouchScreen implements DisplayInterface, ControllerInterface {
  
  TouchScreen() {
    System.out.println("TouchScreen created");
  }

}
