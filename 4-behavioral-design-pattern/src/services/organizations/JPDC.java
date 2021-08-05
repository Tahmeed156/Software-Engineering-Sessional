package organizations;

import mediator.MediatorInterface;

public class JPDC extends Organization {

  public JPDC(MediatorInterface _mediator) {
    super(_mediator);
  }

  @Override
  public String getName() {
    return "JPDC";
  }
  
}
