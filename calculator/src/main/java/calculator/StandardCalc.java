package calculator;

import java.util.Scanner;

/**
 * Infix calculator in which an expression is translated into postfix form using the Shunting Yard
 * algorithm and passed to the RevPolishCalc for evaluation.
 * 
 * @author ZHAC004
 *
 */
public class StandardCalc implements Calculator {

  /*
   * StrStack string will create the postfix form however when popped it will be in reverse which is
   * why another StrStack is used which will have the reverse postfix form. ops will only store
   * operators while revCalc does the actual postfix calculation.
   * 
   */
  private OpStack ops = new OpStack();
  private StrStack string = new StrStack();
  private StrStack revStr = new StrStack();
  private RevPolishCalc revCalc = new RevPolishCalc();

  /**
   * The Shunting Yard algorithm is executed here in which the user's infix expression is translated
   * into postfix and passed to the RevPolishCalc for evaluation.
   * 
   * @param exp the string used for evaluation
   * @return expression that is evaluated
   * @throws InvalidExpression thrown when the expression cannot be evaluated
   * @throws BadTypeException thrown when the wrong type is used
   */
  public float evaluate(String exp) throws InvalidExpression, BadTypeException {

    Scanner scan = new Scanner(exp);
    Symbol symbol;
    String postfix = "";

    while (scan.hasNext()) {

      String token = scan.next();

      /*
       * If the incoming token is an operand push it onto the StrStack. If there already exists an
       * operand within the stack and there's no operators being pushed, it's an unbalanced
       * expression.
       */
      if (!isOperator(token)) {
        if (string.size() == 1 && ops.size() == 0) {
          scan.close();
          string.empty();
          throw new InvalidExpression("Unbalanced expression!");
        }
        string.push(token);

        /*
         * If the incoming token is a left bracket push it onto the OpStack.
         */
      } else if (token.charAt(0) == '(') {
        symbol = Symbol.LEFT_BRACKET;
        ops.push(symbol);

        /*
         * If the incoming token is a right bracket, pop the OpStack and push it into the StrStack
         * until a left bracket is reached. Then pop the OpStack again to discard the left bracket.
         */
      } else if (token.charAt(0) == ')') {
        while (ops.top() != Symbol.LEFT_BRACKET) {
          symbol = ops.pop();
          string.push(symbol.toString());
        }
        ops.pop();

        /*
         * If the incoming token is an operator and the OpStack is empty or the top of the OpStack
         * contains a left bracket, push the incoming operator to the OpStack.
         */
      } else if (isOperator(token) && (ops.isEmpty() || ops.top() == Symbol.LEFT_BRACKET)) {
        ops.push(getOperator(token.charAt(0)));

        /*
         * If the incoming token is an operator and has higher precedence than the operator on top
         * of the OpStack, push the incoming operator to the OpStack.
         */
      } else if (isOperator(token) && precedence(token) > precedence(ops.top().toString())) {
        ops.push(getOperator(token.charAt(0)));

        /*
         * If the incoming token is an operator and has less than or equal precedence to the
         * operator on top of the stack, repeatedly pop the OpStack into the StrStack until this is
         * false. Then push the incoming operator to the OpStack.
         */
      } else if (isOperator(token) && precedence(token) <= precedence(ops.top().toString())) {
        while (!ops.isEmpty() && (precedence(token) <= precedence(ops.top().toString()))) {
          string.push(ops.pop().toString());
        }
        ops.push(getOperator(token.charAt(0)));
      }
    }
    scan.close();

    /*
     * At the end of the Shunting Yard algorithm, if the OpStack is empty it will throw an
     * InvalidExpression error due to no operators. Otherwise, pop the remaining operators to the
     * StrStack string. Finally, we need to pop the infix expression in string to revStr to get it
     * in reverse as it will be passed to an actual String after.
     */
    if (ops.isEmpty()) {
      string.empty();
      throw new InvalidExpression("No operators were used!");
      
    } else {
      while (!ops.isEmpty()) {
        symbol = ops.pop();
        string.push(symbol.toString());
      }
    }   
    while (!string.isEmpty()) {
      revStr.push(string.pop());
    }
    
    /*
     * Now the reverse postfix expression needs to be placed into a literal String. Since it's
     * reversed, when we pop revStr into the String postfix we get it back in its orginal form.
     */
    while (!revStr.isEmpty()) {
      postfix += revStr.pop();
      postfix += " ";
    }
    return revCalc.evaluate(postfix);
  }


  /**
   * Checks if the incoming token is an operator or not via precedence.
   * 
   * @param str the string being checked
   * @return returns true if the token is an operator otherwise false
   * @throws InvalidExpression if the expression cannot be evaluated
   */
  private boolean isOperator(String str) throws InvalidExpression {
    return precedence(str) > 0;
  }


  /**
   * Get the corresponding Symbol for the operator being used.
   * 
   * @param op the token being processed to convert to a Symbol type
   * @return returns the corresponding Symbol
   * @throws InvalidExpression if the expression cannot be evaluated
   */
  private Symbol getOperator(char op) throws InvalidExpression {
    switch (op) {
      case '+':
        return Symbol.PLUS;
      case '-':
        return Symbol.MINUS;
      case '*':
        return Symbol.TIMES;
      case '/':
        return Symbol.DIVIDE;
      default:
        throw new InvalidExpression("Unsuitable operators used in expression");
    }
  }


  /**
   * Places the operators into a precedence level in order to be used for the Shunting Yard. Non
   * operators are given level 0 precedence.
   * 
   * @param op incoming token to place into a precedence level
   * @return returns the int value of the precedence for the operator or even operand
   * @throws InvalidExpression if the expression cannot be evaluated
   */
  private int precedence(String op) throws InvalidExpression {
    char operator = op.charAt(0);
    switch (operator) {
      case '(':
      case ')':
        return 1;
      case '+':
      case '-':
        return 2;
      case '/':
      case '*':
        return 3;
      default:
        return 0;
    }
  }

}


