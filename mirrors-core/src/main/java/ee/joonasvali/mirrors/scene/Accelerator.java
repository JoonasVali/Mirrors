package ee.joonasvali.mirrors.scene;

import java.awt.*;

public class Accelerator extends RoundPhysical implements Collidable {
  private double acceleration;

  public Accelerator(double x, double y, double rotation, double radius, double acceleration) {
    super(x, y, rotation, radius);
    this.acceleration = acceleration;
  }

  @Override
  public boolean isCollision(Particle particle) {
    return CollisionUtil.areColliding(this, particle.getX(), particle.getY());
  }

  @Override
  public void actCollision(Particle particle, Model model) {
    particle.setSpeed(particle.getSpeed() + acceleration);
  }

  @Override
  public void render(Graphics2D g) {
    if (acceleration > 0) {
      g.setColor(Color.green);
    } else g.setColor(Color.yellow);
    g.drawOval((int) getX(), (int) getY(), (int) getWidth(), (int) getHeight());
    g.drawString(String.format("%.1f", acceleration), (float) getCenterX() - 10, (float) getCenterY() - 10);
  }
}
