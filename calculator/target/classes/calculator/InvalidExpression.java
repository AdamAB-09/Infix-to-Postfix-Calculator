package calculator;

/**
 * Custom exception class in order to handle any expressions that can't be calculated.
 * 
 * @author ZHAC004
 *
 */
public class InvalidExpression extends RuntimeException {


  private static final long serialVersionUID = 1674080149576344363L;
  
  /**
   * Constructor for the InvalidExpression to take a String in its parameter.
   * 
   * @param message to output to the user when a invalid expression is entered
   */
  public InvalidExpression(String message) {
    super(message);
  }


}
