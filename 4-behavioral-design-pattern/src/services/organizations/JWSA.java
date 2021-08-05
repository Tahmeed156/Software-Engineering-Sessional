package organizations;

import mediator.MediatorInterface;

public class JWSA extends Organization {

  public JWSA(MediatorInterface _mediator) {
    super(_mediator);
  }

  @Override
  public String getName() {
    return "JWSA";
  }
  
}
