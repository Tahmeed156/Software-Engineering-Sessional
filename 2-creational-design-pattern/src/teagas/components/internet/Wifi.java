package components.internet;

class Wifi implements InternetInterface {
  
  Wifi() {
    System.out.println("Wifi created");
  }

  @Override
  public boolean isAvailable() {
    System.out.println("Strong internet connection!");
    return true;
  }
  
}
