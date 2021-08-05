package components.micro;

import components.storage.StorageInterface;

class RaspberryPi implements MicroInterface, StorageInterface {  

  RaspberryPi() {
    System.out.println("RaspberryPi created");
  }

  @Override
  public void backupData(float weight, String collector_id) {
    System.out.println("Backup up data (" + weight + ", " + collector_id + ")");
  }
  
}
