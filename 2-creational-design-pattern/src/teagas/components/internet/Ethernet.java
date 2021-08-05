package components.internet;

class Ethernet implements InternetInterface {
  
  Ethernet() {
    System.out.println("Ethernet created");
  }

  @Override
  public boolean isAvailable() {
    System.out.println("Strong internet connection!");
    return true;
  }
  
}
