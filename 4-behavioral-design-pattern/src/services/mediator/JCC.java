package mediator;

import java.util.Base64;

import organizations.OrganizationInterface;

public class JCC implements MediatorInterface {

  private OrganizationInterface waterService; 
  private OrganizationInterface energyService; 
  private OrganizationInterface transportService; 
  private OrganizationInterface telecomService;
  
  public JCC() {}
  
  public void addServices(
    OrganizationInterface water, 
    OrganizationInterface energy, 
    OrganizationInterface transport, 
    OrganizationInterface telecom
  ) {
    this.waterService = water;
    this.energyService = energy;
    this.transportService = transport;
    this.telecomService = telecom;
  }
  
  public void request(OrganizationInterface sender, String service) {
    System.out.println(sender.getName() + " requests for " + service + " service");
    String senderId = Base64.getEncoder().encodeToString(sender.getName().getBytes());
    switch(service) {
      case "WATER":
        this.waterService.enqueue(senderId);
        break;
      case "ENERGY":
        this.energyService.enqueue(senderId);
        break;
      case "TRANSPORT":
        this.transportService.enqueue(senderId);
        break;
      case "TELECOM":
        this.telecomService.enqueue(senderId);
        break;
    }
  }
  
  public void serve(OrganizationInterface service, String receiverId) {
    byte[] decodedBytes = Base64.getDecoder().decode(receiverId);
    String receiver = new String(decodedBytes);
    System.out.println(service.getName() + " served the request of " + receiver);
  }

}
