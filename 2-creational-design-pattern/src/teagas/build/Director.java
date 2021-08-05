package build;

import hardware.HardwareInterface;
import server.ServerInterface;

public class Director {
  
  private PackageBuilderInterface builder;

  public Director(String _packageName) throws Exception {

    switch(_packageName) {
      case "Gold":
        this.builder = new GoldPackageBuilder();
        break;
      case "Silver":
        this.builder = new SilverPackageBuilder();
        break;
      case "Diamond":
        this.builder = new DiamondPackageBuilder();
        break;
      case "Platinum":
        this.builder = new PlatinumPackageBuilder();
        break;
      default:
        throw new Exception("ERROR: Invalid package name");
    }
  }

  public void buildProduct(String _internetType, String _serverType) throws Exception {
    this.builder.setupHardware();
    this.builder.addInternet(_internetType);
    this.builder.addServer(_serverType);
  }

  public HardwareInterface getHardware() {
    return this.builder.getHardware();
  }

  public ServerInterface getServer() {
    return this.builder.getServer();
  }

}
