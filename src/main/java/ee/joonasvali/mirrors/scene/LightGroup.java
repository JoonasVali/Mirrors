package ee.joonasvali.mirrors.scene;

import java.awt.*;
import java.io.Serializable;

public class LightGroup implements Serializable {
  private final int id;

  private Color[] colors = new Color[256];

  public LightGroup(int id, Color color) {
    this.id = id;

    for (int i = 0; i < colors.length; i++) {
      colors[i] = new Color(color.getRed(), color.getGreen(), color.getBlue(), i);
    }
  }

  public void render(Graphics2D g, double x, double y, double intensity, double initialIntensity) {
    if (intensity < 0) {
      return;
    }
    int rate = (int) (intensity / initialIntensity * 255);
    g.setColor(colors[rate]);

    g.drawLine((int)x, (int)y, (int)x, (int)y);
  }

  public Color getColor() {
    return colors[255];
  }

  public int getId() {
    return id;
  }
}
