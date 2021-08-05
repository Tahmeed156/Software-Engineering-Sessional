package components.identity;

class NFC implements IdentityInterface {
      
  NFC() {
    System.out.println("NFC created");
  }

  @Override
  public String scan() {
    String _collectorId = "8h5jve7";
    System.out.println("Successfully identified collector # " + _collectorId);
    return _collectorId;
  }

}
