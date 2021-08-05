package factory;

import aesthetic.AestheticsInterface;
import parser.ParserInterface;

public interface AbstractFactory {

  ParserInterface getParser();
  AestheticsInterface getAesthetics();

}
