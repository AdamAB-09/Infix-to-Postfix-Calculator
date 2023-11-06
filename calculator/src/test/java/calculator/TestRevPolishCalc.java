package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {

  private RevPolishCalc postfix;

  @BeforeEach
  void startUp() {
    postfix = new RevPolishCalc();
  }


  @Test // Test 1
  void testAddition() throws InvalidExpression, BadTypeException {
    assertEquals(postfix.evaluate("-6 -2 +"), -8.0, "Result of expression should be -8.0");
    assertEquals(postfix.evaluate("3 4 + 2 +"), 9.0, "Result of expression should be 9.0");
    assertEquals(postfix.evaluate("5 6 7 + + 2 +"), 20.0, "Result of expression should be 20.0");
  }

  @Test // Test 2
  void testMultiplication() throws InvalidExpression, BadTypeException {
    assertEquals(postfix.evaluate("6 4 *"), 24.0, "Result of the expression should be 24.0");
    assertEquals(postfix.evaluate("2 4 * 5 *"), 40.0, "Result of the expression should be 40.0");
    assertEquals(postfix.evaluate("2 3 2 * * 4 *"), 48.0,
        "Result of the expression should be 48.0");
  }

  @Test // Test 3
  void testSubtraction() throws InvalidExpression, BadTypeException {
    assertEquals(postfix.evaluate("3 7 -"), -4.0, "Result of the expression should be -4.0");
    assertEquals(postfix.evaluate("10 4 - 3 -"), 3.0, "Result of the expression should be 3.0");
    assertEquals(postfix.evaluate("50 9 5 - - 10 -"), 36.0,
        "Result of the expression should be 36.0");
  }

  @Test // Test 4
  void testDivision() throws InvalidExpression, BadTypeException {
    assertEquals(postfix.evaluate("18 9 /"), 2.0, "Result of the expression should be 2.0");
    assertEquals(postfix.evaluate("40 4 / 4 /"), 2.5, "Result of the expression should be 2.5");
    assertEquals(postfix.evaluate("85 25 5 / / 4 /"), 4.25,
        "Result of the expression should be 4.25");
  }

  @Test // Test 5
  void testAllOperators() throws InvalidExpression, BadTypeException {
    assertEquals(postfix.evaluate("5 6 7 + * 2 -"), 63.0,
        "Result of the expression should be 63.0");
    assertEquals(postfix.evaluate("10 24 4 / + 2 * -5 -"), 37.0,
        "Result of the expression should be 37.0");
  }

  @Test // Test 6
  void testInvalidExpression() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> postfix.evaluate("2 5 3 + * 0 /"),
        "Unable to divide by zero");
    assertThrows(InvalidExpression.class, () -> postfix.evaluate("3 2 AB /"),
        "Only operands and the 4 operators can be used in a expression");
    assertThrows(InvalidExpression.class, () -> postfix.evaluate("13+"),
        "Expression is unbalanced as there's only 1 operand");
    assertThrows(InvalidExpression.class, () -> postfix.evaluate("2 3 + 5"),
        "Expression is unbalanced as last operand isn't evaluated with any operator");
    assertEquals(postfix.evaluate("5 2 +"), 7.0,
        "Checking to see if after error handling, any of the operands remain in the stack");
  }

}
