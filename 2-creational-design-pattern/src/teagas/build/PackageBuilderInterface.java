package build;

import hardware.HardwareInterface;
import server.ServerInterface;

public interface PackageBuilderInterface {
  
  void setupHardware() throws Exception;
  void addInternet(String _internetType) throws Exception;
  void addServer(String _serverType) throws Exception;

  HardwareInterface getHardware();
  ServerInterface getServer();
}
