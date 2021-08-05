package components.storage;

class SDCard implements StorageInterface {
  
  SDCard() {
    System.out.println("SDCard created");
  }

  @Override
  public void backupData(float weight, String collector_id) {
    System.out.println("Backup up data (" + weight + ", " + collector_id + ")");
  }

}
