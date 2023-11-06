package calculator;

/**
 * The interface used to implement the algorithms for the calculator.
 * 
 * @author ZHAC004
 *
 */
public interface Calculator {
  
  /**
   * Used to evaluate the expression the user inputs.
   * 
   * @param exp the expression to be evaluated
   * @return the expression that is calculated
   * @throws InvalidExpression thrown if the expression is unable to be evaluated
   * @throws BadTypeException thrown if the expression is of wrong type
   */
  float evaluate(String exp) throws InvalidExpression, BadTypeException;

}
