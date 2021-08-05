package server;

class Laravel implements ServerInterface {
    
  Laravel() {
    System.out.println("Laravel created");
  }

  @Override
  public void analyzeData() {
    System.out.println("# ANALYSIS");
    System.out.println("Total collectors: 10");
    System.out.println("Collected today: 57.5kg");
    System.out.println("Weekly history: 200kg");
  }

  @Override
  public void addCollector(String _username) {
    System.out.println("Added new collector: " + _username);
  }

  @Override
  public void removeCollector(String _username) {
    System.out.println("Removed collector: " + _username);
  }
  
}
