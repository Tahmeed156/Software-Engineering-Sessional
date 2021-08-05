import mediator.JCC;
import mediator.MediatorInterface;
import organizations.JPDC;
import organizations.JRTA;
import organizations.JTRC;
import organizations.JWSA;
import organizations.OrganizationInterface;

public class App {

  public static void main (String [] args) {

    // initialization
    MediatorInterface med = new JCC();
    OrganizationInterface jwsa = new JWSA(med);
    OrganizationInterface jpdc = new JPDC(med);
    OrganizationInterface jrta = new JRTA(med);
    OrganizationInterface jtrc = new JTRC(med);
    med.addServices(jwsa, jpdc, jrta, jtrc);

    jwsa.request("ENERGY");
    jrta.request("ENERGY");
    jpdc.request("TELECOM");
    jpdc.serve();
    jpdc.serve();
  }

}