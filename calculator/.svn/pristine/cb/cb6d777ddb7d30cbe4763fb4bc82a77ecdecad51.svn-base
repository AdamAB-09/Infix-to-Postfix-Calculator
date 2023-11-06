package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNumStack {

  private NumStack num;

  @BeforeEach
  void startUp() {
    num = new NumStack();
  }


  @Test // Test 1
  void testPush() {
    num.push(2.5f);
    assertEquals(num.size(), 1, "After a single push there should be 1 element in the num stack");
    num.push(9.5f);
    assertEquals(num.size(), 2, "After two pushes there should be 2 elments in the num stack");
  }

  @Test // Test 2
  void testEmptyStack() {
    assertTrue(num.isEmpty(), "Initially the NumStack should return empty with nothing pushed");
    assertThrows(EmptyStackException.class, () -> num.pop(), "Can't pop from an empty stack");
    num.push(1.2f);
    assertFalse(num.isEmpty(), "NumStack no longer empty as an element is pushed");
  }

  @Test // Test 3
  void testPushAndPop() throws BadTypeException {
    num.push(53.5f);
    assertEquals(num.pop(), 53.5f, "53.5 should be returned as it was the last element pushed");
    assertEquals(num.size(), 0, "Size of stack is 0 again");
  }

  @Test // Test 4
  void testPushAndPopMultiple() throws BadTypeException {
    num.push(1.4f);
    num.push(93.65f);
    assertEquals(num.pop(), 93.65f, "Popping once should return latest entry being 93.65f");
    assertEquals(num.pop(), 1.4f, "Popping again should return previous entry being 1.4f");
    for (float i = 0f; i < 250.0f; i++) {
      num.push(i);
    }
    assertEquals(num.size(), 250, "Size should equal the number of float values added to NumStack");
  }
  
  @Test // Test 5
  void testEmpty() {
    num.push(94.f);
    num.push(10.0f);
    num.push(21.3f);
    num.empty();
    assertEquals(num.size(), 0);
  }

}
