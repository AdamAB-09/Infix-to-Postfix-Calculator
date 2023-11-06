package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {

  private OpStack op;

  @BeforeEach
  void startUp() {
    op = new OpStack();
  }

  @Test // Test 1
  void testPush() {
    op.push(Symbol.PLUS);
    assertEquals(op.size(), 1, "Size of OpStack should be 1 afer pushing once");
    op.push(Symbol.MINUS);
    assertEquals(op.size(), 2, "Size of OpStack should be 2 after pushing again");
  }

  @Test // Test 2
  void testEmptyStack() {
    assertTrue(op.isEmpty(), "OpStack should be empty intially without any pushes");
    assertThrows(EmptyStackException.class, () -> op.pop(), "Can't pop from an empty stack");
    op.push(Symbol.DIVIDE);
    assertFalse(op.isEmpty(), "After pushing a Symbol the isEmpty method should return false");
  }

  @Test // Test 3
  void testPushAndPop() throws BadTypeException {
    op.push(Symbol.DIVIDE);
    assertEquals(op.pop(), Symbol.DIVIDE, "Symbol.DIVIDE should be removed and returned after pop");
    assertEquals(op.size(), 0, "Size of OpStack is 0 again");
  }

  @Test // Test 4
  void testPushAndPopMultiple() throws BadTypeException {
    op.push(Symbol.RIGHT_BRACKET);
    op.push(Symbol.LEFT_BRACKET);
    assertEquals(op.pop(), Symbol.LEFT_BRACKET, "Latest Symbol being pushed should be popped");
    assertEquals(op.pop(), Symbol.RIGHT_BRACKET, "Popping again should pop the first Symbol push");
    for (int i = 0; i < 400; i++) {
      op.push(Symbol.PLUS);
    }
    assertEquals(op.size(), 400, "Size should equal the number of Symbol values added to NumStack");
  }

  @Test // Test 5
  void testTop() throws BadTypeException {
    op.push(Symbol.DIVIDE);
    op.push(Symbol.LEFT_BRACKET);
    op.push(Symbol.MINUS);
    assertEquals(op.top(), Symbol.MINUS, "Checking if top returns latest Symbol being MINUS");
    op.push(Symbol.INVALID);
    assertEquals(op.top(), Symbol.INVALID,
        "Another symbol has been pushed and should return the latest Symbol being INVALID");
  }

}
