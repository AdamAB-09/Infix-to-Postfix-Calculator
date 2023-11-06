package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardCalc {

  private StandardCalc calc;
  private RevPolishCalc revCalc;

  @BeforeEach
  void startUp() {
    calc = new StandardCalc();
    revCalc = new RevPolishCalc();
  }

  @Test // Test 6
  void testAdditionOnly() throws InvalidExpression, BadTypeException {
    assertEquals(calc.evaluate("5 + 2 + 9"), revCalc.evaluate("5 2 + 9 +"),
        "Checking to see if infix expression returns same value as postfix expression");
    assertEquals(calc.evaluate("5 + 2 + 9"), 16.0f, "Expression should evaluate to 18.0");
  }

  @Test // Test 7
  void testSubtractionOnly() throws InvalidExpression, BadTypeException {
    assertEquals(calc.evaluate("3 - 2 - 15"), revCalc.evaluate("3 2 - 15 -"),
        "Checking to see if infix expression returns same value as postfix expression");
    assertEquals(calc.evaluate("3 - 2 - 15"), -14.0f, "Expression should evaluate to -14.0");
  }

  @Test // Test 8
  void testMultiplicationOnly() throws InvalidExpression, BadTypeException {
    assertEquals(calc.evaluate("3 * 2 * 8 * 4"), revCalc.evaluate("3 2 * 8 * 4 *"),
        "Checking to see if infix expression returns same value as postfix expression");
    assertEquals(calc.evaluate("3 * 2 * 8 * 4"), 192.0f, "Expression should evaluate to 192.0");
  }

  @Test // Test 9
  void testDivOnly() throws InvalidExpression, BadTypeException {
    assertEquals(calc.evaluate("60 / 5 / 6 / 5"), revCalc.evaluate("60 5 / 6 / 5 /"),
        "Checking to see if infix expression returns same value as postfix expression");
    assertEquals(calc.evaluate("60 / 5 / 6 / 5"), 0.4f, "Expression should evaluate to 0.4");
  }

  @Test // Test 10
  void testParentheses() throws InvalidExpression, BadTypeException {
    assertEquals(calc.evaluate("11 - ( 6 / 4 )"), revCalc.evaluate("11 6 4 / -"),
        "Testing expression with only one pair of parentheses");
    assertEquals(calc.evaluate("11 - ( 6 / 4 )"), 9.5f, "Expression should evaluate to 9.5");
    assertEquals(calc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), revCalc.evaluate("5 6 7 + * 2 -"),
        "Testing expression with only two pair of parentheses");
    assertEquals(calc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63.0f,
        "Expression should evaluate to 63.0");
    assertEquals(calc.evaluate("12 + 5 * ( 3 / 6 + 4 - 2 ) - 4"),
        revCalc.evaluate("12 5 3 6 / 4 + 2 - * + 4 -"),
        "Testing expression to check if precedence if tested within parentheses");
    assertEquals(calc.evaluate("12 + 5 * ( 3 / 6 + 4 - 2 ) - 4"), 20.5f,
        "Expression should evaluate to 20.5");
  }

  @Test // Test 11
  void testInvalidExpression() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> calc.evaluate("4 + 5 % 3"),
        "Error handling of invalid operators handled by RevPolishCalc");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("A + B - 3"),
        "Error handling of non operands handled by RevPolishCalc");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("4 + 3 6 + 9"),
        "Unbalanced expression that needs to be thrown");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("9 3"),
        "No operators being used only operands");
    assertThrows(InvalidExpression.class, () -> calc.evaluate("9 10 + -"),
        "Postfix expression being used rather than infix");
    
  }

}
