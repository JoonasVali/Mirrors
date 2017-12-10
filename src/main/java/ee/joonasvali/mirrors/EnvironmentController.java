package ee.joonasvali.mirrors;

import ee.joonasvali.mirrors.scene.Environment;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * @author Joonas Vali April 2016
 */
public interface EnvironmentController {
  void init();

  void render(Graphics2D g);

  void nextStep();

  Environment getEnvironment();

  KeyListener getKeyListener();
}
