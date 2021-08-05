package factory;

import aesthetic.*;
import aesthetic.color.BlueColor;
import aesthetic.font.Consolas;
import aesthetic.style.NormalStyle;
import parser.*;

public class PythonFactory implements AbstractFactory {

  @Override
  public ParserInterface getParser() {
    return new CppParser();
  }

  @Override
  public AestheticsInterface getAesthetics() {
    Aesthetics aesthetics = new Aesthetics();
    aesthetics.setColor(new BlueColor());
    aesthetics.setStyle(new NormalStyle());
    aesthetics.setFont(new Consolas());
    return aesthetics;
  }
  
}
