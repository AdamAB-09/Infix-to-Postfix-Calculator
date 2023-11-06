package calculator;

import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Algorithm to calculate a postfix expression input by the user.
 * 
 * @author ZHAC004
 *
 */
public class RevPolishCalc implements Calculator {

  private NumStack stack = new NumStack();


  /**
   * The evaluation works in a way such that the String is evaluated from left to right, inserting
   * only operands into the stack and when an operator is reached it will pop the last two operands
   * from the stack and get their result using that operator. This is repeated until the end of the
   * String.
   * 
   * @param exp the string used for evaluation
   * @return expression that is calculated
   * @throws InvalidExpression thrown when the expression cannot be evaluated
   * @throws BadTypeException thrown when the wrong type is used
   */
  public float evaluate(String exp) throws InvalidExpression, BadTypeException {

    Scanner scan = new Scanner(exp);

    /*
     * The operand that is spotted in the String is added to the stack and continues to the next
     * iteration otherwise if an operator is spotted the if statement isn't executed.
     */
    while (scan.hasNext()) {
      if (scan.hasNextInt()) {
        stack.push(scan.nextInt());
        continue;
      }

      try {
        /*
         * The operand to the left of the operator is popped and then the other operand is also
         * popped. As the next token in the String is an operator it is stored in a variable and
         * used for evaluation.
         */
        float second = stack.pop();
        float first = stack.pop();
        char operator = scan.next().charAt(0);

        /*
         * Depending on the operator used, the corresponding calculations are executed for the two
         * operands that were previously popped and their result is pushed backed into the stack.
         * Any invalid expressions are handled such as division by 0, non operator/operands used or
         * an unbalanced expression when there aren't two operands to be popped.
         */
        switch (operator) {
          case '+':
            stack.push(first + second);
            break;
          case '*':
            stack.push(first * second);
            break;
          case '-':
            stack.push(first - second);
            break;
          case '/':
            if (second == 0) {
              throw new InvalidExpression("Cannot divide by zero");
            } else {
              stack.push(first / second);
            }
            break;
          default:
            throw new InvalidExpression("Invalid expression!");
        }
      } catch (EmptyStackException e) {
        scan.close();
        throw new InvalidExpression("Unbalanced expression!");
      }
    }
    scan.close();
    /*
     * At the end of the evaluation there should only remain the result of the user's expression in
     * the stack, thus if there are any other remaining operands inside the stack it needs to be
     * emptied and throw an error.
     */
    if (stack.size() > 1) {
      stack.empty();
      throw new InvalidExpression("Unbalanced expression!");
    } else {
      return stack.pop();
    }
  }
}

