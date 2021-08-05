package factory;

import aesthetic.*;
import aesthetic.color.BlueColor;
import aesthetic.font.Monaco;
import aesthetic.style.NormalStyle;
import parser.*;

public class CppFactory implements AbstractFactory {

  @Override
  public ParserInterface getParser() {
    return new CppParser();
  }

  @Override
  public AestheticsInterface getAesthetics() {
    Aesthetics aesthetics = new Aesthetics();
    aesthetics.setColor(new BlueColor());
    aesthetics.setStyle(new NormalStyle());
    aesthetics.setFont(new Monaco());
    return aesthetics;
  }

}
