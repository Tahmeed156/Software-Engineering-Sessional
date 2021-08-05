package components.identity;

class RFID implements IdentityInterface {
        
  RFID() {
    System.out.println("RFID created");
  }
  
  @Override
  public String scan() {
    String _collectorId = "8h5jve7";
    System.out.println("Successfully identified collector # " + _collectorId);
    return _collectorId;
  }

}
