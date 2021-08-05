package aesthetic;

import aesthetic.color.ColorInterface;
import aesthetic.font.FontInterface;
import aesthetic.style.StyleInterface;

public class Aesthetics implements AestheticsInterface {

  private FontInterface font;
  private ColorInterface color;
  private StyleInterface style;
    
  public void setFont(FontInterface _font) {
    this.font = _font;
  }

  public void setColor(ColorInterface _color) {
    this.color = _color;
  }

  public void setStyle(StyleInterface _style) {
    this.style = _style;
  }
}
