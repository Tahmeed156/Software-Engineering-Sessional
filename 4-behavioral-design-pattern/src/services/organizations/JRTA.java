package organizations;

import mediator.MediatorInterface;

public class JRTA extends Organization {

  public JRTA(MediatorInterface _mediator) {
    super(_mediator);
  }

  @Override
  public String getName() {
    return "JRTA";
  }
  
}
