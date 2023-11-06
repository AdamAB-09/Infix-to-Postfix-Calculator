package calculator;

/**
 * A singleton enum which acts as a model for the assembly by passing expressions to the
 * corresponding calculator.
 * 
 * @author adamt
 *
 */
public enum CalcModel {

  INSTANCE;

  private RevPolishCalc postfixCalc = new RevPolishCalc();
  private StandardCalc infixCalc = new StandardCalc();


  /**
   * The user passes an expression with the boolean of whether it's an infix expression or not, and
   * the expression is passed to the correct calculator for evaluation.
   * 
   * @param exp expression passed in by the user
   * @param infix boolean signifying whether the expression is infix or postfix
   * @return returns the evaluated expression 
   * @throws InvalidExpression thrown when expression cannot be evaluated 
   * @throws BadTypeException thrown when incorrect type is used
   */
  public float evaluate(String exp, boolean infix) throws InvalidExpression, BadTypeException {
    if (infix) {
      return infixCalc.evaluate(exp);
    } else {
      return postfixCalc.evaluate(exp);
    }
  }

}
