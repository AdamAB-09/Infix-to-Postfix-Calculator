package calculator;

/**
 * Acts as a driver for the JavaFX by creating all the corresponding framework.
 * 
 * @author ZHAC004
 *
 */
public class Launcher {

  /**
   * Used to start the JavaFX application.
   * 
   * @param args command line argument passed to the JavaFX Application
   */
  public static void main(String[] args) {
    ViewInterface view = GuiView.getInstance();
    new CalcController(view);
  }

}

