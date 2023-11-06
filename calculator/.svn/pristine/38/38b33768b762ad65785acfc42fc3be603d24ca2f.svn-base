package calculator;

import java.io.IOException;
import java.util.function.Consumer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * The GUI for the calculator for the user to interact with. It's an singleton in which only one
 * instance can exist.
 * 
 * @author ZHAC004
 */
public class GuiView extends Application implements ViewInterface {


  @FXML
  private Button calcButton;

  @FXML
  private Button resetButton;

  @FXML
  private RadioButton postfixButton;

  @FXML
  private ToggleGroup type;

  @FXML
  private RadioButton infixButton;

  @FXML
  private TextField expression;

  @FXML
  private TextField answer;

  private static volatile GuiView instance = null;

  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * To be called by the launcher to get a single GuiView during runtime.
   * 
   * @return returns the instance of the GuiView
   */
  public static synchronized GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
      while (instance == null) {
      }
    }
    return instance;
  }


  /**
   * Generates the scene and view of the JavaFX application.
   */
  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("GuiConfig.fxml"));
    Scene scene = new Scene(root);
    scene.getStylesheets()
        .add(getClass().getClassLoader().getResource("application.css").toExternalForm());
    primaryStage.setScene(scene);
    primaryStage.setTitle("Calculator");
    primaryStage.show();
  }

  /**
   * A getter in order to get the user's arithmetic expression.
   * 
   * @return the expression inserted to the calculator
   */
  @Override
  public String getExpression() {
    return expression.getText();
  }

  /**
   * A setter in order to display the evaluated answer.
   * 
   * @param str the answer of expression
   */
  @Override
  public void setAnswer(String str) {
    answer.setText(str);
  }

  /**
   * Add an observer to the reset button.
   * 
   * @param observer the observer being added
   */
  @Override
  public void addResetObserver(Observer observer) {
    resetButton.setOnAction(event -> observer.tell());
  }

  /**
   * Add an observer to the calculate action.
   * 
   * @param observer the observer being added
   */
  @Override
  public void addCalcObserver(Observer observer) {
    calcButton.setOnAction(event -> observer.tell());
  }

  /**
   * Add an observer to the different calculate modes.
   * 
   * @param i observer being added
   */
  @Override
  public void addTypeObserver(Consumer<OpType> i) {
    type.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        i.accept(to == infixButton ? OpType.INFIX : OpType.POSTFIX);
      }
    });
  }

}
