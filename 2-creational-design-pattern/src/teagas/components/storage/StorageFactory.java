package components.storage;

public class StorageFactory {
    
  public static StorageInterface create(String _storageType) throws Exception {
    
    switch(_storageType) {
      case "SDCard":
        return new SDCard();
      default:
        throw new Exception("ERROR: Invalid storage type");
    }
  }

}
