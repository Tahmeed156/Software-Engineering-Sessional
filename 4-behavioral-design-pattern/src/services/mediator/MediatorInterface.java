package mediator;

import organizations.OrganizationInterface;

public interface MediatorInterface {
  
  void addServices(
    OrganizationInterface water, 
    OrganizationInterface energy, 
    OrganizationInterface transport, 
    OrganizationInterface telecom
  );
  public void request(OrganizationInterface sender, String service);
  public void serve(OrganizationInterface service, String receiverId);

}
