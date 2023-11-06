package calculator;

import java.util.function.Consumer;

/**
 * Interface to be implemented for the view and interaction of the calculator.
 * 
 * @author ZHAC004
 *
 */
public interface ViewInterface {


  /**
   * A getter in order to get the arithmetic expression.
   * 
   * @return the expression inserted to the calculator
   */
  String getExpression();


  /**
   * A setter in order to display the evaluated answer.
   * 
   * @param str the answer of expression
   */
  void setAnswer(String str);


  /**
   * Add an observer to the calculate action.
   * 
   * @param observer the observer being added
   */
  void addCalcObserver(Observer observer);


  /**
   * Add an observer to the different calculate modes.
   * 
   * @param i observer being added
   */
  void addTypeObserver(Consumer<OpType> i);
  
  /**
   * Add an observer to the reset button.
   * 
   * @param observer the observer being added
   */
  void addResetObserver(Observer observer);

}
