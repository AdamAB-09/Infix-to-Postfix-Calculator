package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TestCalcModel {

  private boolean infix = true;
  private boolean postfix = false;

  @Test // Test 1
  void testEvaluate() throws InvalidExpression, BadTypeException {
    assertEquals(CalcModel.INSTANCE.evaluate("3 + 2 + 6", infix), 11.0f,
        "The following infix expression should be calculated with the infix calculator");
    assertThrows(InvalidExpression.class, () -> CalcModel.INSTANCE.evaluate("3 5 +", infix),
        "Postfix expression being passed to infix calculator should throw exception");
    assertEquals(CalcModel.INSTANCE.evaluate("9 3 + 8 -", postfix), 4.0f,
        "The following postfix expression should be calculated with the postfix calculator");
    assertThrows(InvalidExpression.class, () -> CalcModel.INSTANCE.evaluate("5 + 9 - 11", postfix),
        "Infix expression being passed to postfix calculator should throw exception");
  }

}
