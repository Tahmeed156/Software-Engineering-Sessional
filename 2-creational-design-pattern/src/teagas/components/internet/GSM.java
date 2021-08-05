package components.internet;

class GSM implements InternetInterface {
  
  GSM() {
    System.out.println("GSM created");
  }

  @Override
  public boolean isAvailable() {
    System.out.println("Internet is not available!");
    return false;
  }
  
}
