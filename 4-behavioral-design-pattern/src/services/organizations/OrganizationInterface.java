package organizations;

public interface OrganizationInterface {

  void request(String service);
  void enqueue(String requesterId);
  void serve();
  String getName();
  
}
