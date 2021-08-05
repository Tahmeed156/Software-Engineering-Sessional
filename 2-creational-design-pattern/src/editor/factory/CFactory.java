package factory;

import aesthetic.*;
import aesthetic.color.BlueColor;
import aesthetic.font.CourierNew;
import aesthetic.style.NormalStyle;
import parser.*;

public class CFactory implements AbstractFactory {

  @Override
  public ParserInterface getParser() {
    return new CParser();
  }

  @Override
  public AestheticsInterface getAesthetics() {
    Aesthetics aesthetics = new Aesthetics();
    aesthetics.setColor(new BlueColor());
    aesthetics.setStyle(new NormalStyle());
    aesthetics.setFont(new CourierNew());
    return aesthetics;
  }
}
