package calculator;


/**
 * The controller for the GUI which responds to the user's interaction.
 * 
 * @author ZHAC004
 */
public class CalcController {
  private ViewInterface view;
  private boolean infix = true;

  /**
   * Constructor in which it notifies its observers when there's an event handled in the calculator
   * via the view.
   * 
   * @param view the corresponding interface being used
   */
  protected CalcController(ViewInterface view) {
    this.view = view;
    view.addTypeObserver(this::expressionType);
    view.addResetObserver(this::reset);
    view.addCalcObserver(() -> {
      try {
        calculate();
      } catch (InvalidExpression | BadTypeException e) {
        e.printStackTrace();
      }
    });
  }

  /**
   * Sets the calculator to the corresponding mode depending on which radio button is selected.
   * 
   * @param mode the radio button that is selected
   */
  private void expressionType(OpType mode) {
    if (mode == OpType.INFIX) {
      infix = true;
    } else {
      infix = false;
    }
  }

  /**
   * Passes the user's expression to the CalcModel for evaluation and the result is displayed in the
   * answer box.
   * 
   * @throws BadTypeException thrown if incorrect type is used
   */
  private void calculate() throws BadTypeException {
    try {
      Float result = CalcModel.INSTANCE.evaluate(view.getExpression(), infix);
      view.setAnswer(result.toString());
    } catch (InvalidExpression e) {
      // Error messages are displayed here when an InvalidExpression occurs
      view.setAnswer(e.getMessage()); 
    }
  }

  /**
   * Clears the answer text box when the reset button is pressed.
   */
  private void reset() {
    view.setAnswer(null);
  }

}
