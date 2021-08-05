package organizations;

import mediator.MediatorInterface;

public class JTRC extends Organization {

  public JTRC(MediatorInterface _mediator) {
    super(_mediator);
  }

  @Override
  public String getName() {
    return "JTRC";
  }
  
}
