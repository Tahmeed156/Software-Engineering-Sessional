package hardware;

import components.controller.ControllerInterface;
import components.display.DisplayInterface;
import components.identity.IdentityInterface;
import components.internet.InternetInterface;
import components.micro.MicroInterface;
import components.storage.StorageInterface;
import components.weight.WeightSensorInterface;

public class Hardware implements HardwareInterface {
  
  private MicroInterface micro;
  private WeightSensorInterface weightSensor;
  private IdentityInterface identityCard;
  private StorageInterface storage;
  private DisplayInterface display;
  private ControllerInterface controller;
  private InternetInterface internet;

  @Override
  public void setMicro(MicroInterface _micro) {
    this.micro = _micro;
  }

  @Override
  public MicroInterface getMicro() {
    return this.micro;
  }

  @Override
  public void setWeightSensor(WeightSensorInterface _weightSensor) {
    this.weightSensor = _weightSensor;
  }

  @Override
  public void setIdentityCard(IdentityInterface _identityCard) {
    this.identityCard = _identityCard;
  }

  @Override
  public void setStorage(StorageInterface _storage) {
    this.storage = _storage;
  }

  @Override
  public void setDisplay(DisplayInterface _display) {
    this.display = _display;
  }

  @Override
  public DisplayInterface getDisplay() {
    return this.display;
  }

  @Override
  public void setController(ControllerInterface _controller) {
    this.controller = _controller;
  }

  @Override
  public void setInternet(InternetInterface _internet) {
    this.internet = _internet;
  }

  @Override
  public void scanAndUpload() {

    String collectorId = this.identityCard.scan();

    float weight = this.weightSensor.measure();

    if (!this.internet.isAvailable())
      this.storage.backupData(weight, collectorId);
    else
      System.out.println("Data uploaded successfully!");
  }

}
