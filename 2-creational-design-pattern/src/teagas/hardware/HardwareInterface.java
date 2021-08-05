package hardware;

import components.controller.ControllerInterface;
import components.display.DisplayInterface;
import components.identity.IdentityInterface;
import components.internet.InternetInterface;
import components.micro.MicroInterface;
import components.storage.StorageInterface;
import components.weight.WeightSensorInterface;

public interface HardwareInterface {

  public void setMicro(MicroInterface _micro);
  public MicroInterface getMicro();
  public void setWeightSensor(WeightSensorInterface _weightSensor);
  public void setIdentityCard(IdentityInterface _identityCard);
  public void setStorage(StorageInterface _storage);
  public void setDisplay(DisplayInterface _display);
  public DisplayInterface getDisplay();
  public void setController(ControllerInterface _controller);
  public void setInternet(InternetInterface _internet);

  public void scanAndUpload();

}
