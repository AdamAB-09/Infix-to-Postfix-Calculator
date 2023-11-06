package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {
  
  private StrStack str;

  @BeforeEach
  void startUp() {
    str = new StrStack();
  }
  
  @Test // Test 1
  void testPush() {
    str.push("Bob");
    assertEquals(str.size(), 1, "Size of StrStack should be 1 after pushing once");
    str.push("Test");
    assertEquals(str.size(), 2, "Size of StrStack should be 2 after pushing twice");
  }
  
  @Test // Test 2
  void testEmptyStack() {
    assertTrue(str.isEmpty(), "Should return true as stack is initially empty at instantiation");
    assertThrows(EmptyStackException.class, () -> str.pop(), "Can't pop from an empty stack");
    str.push("String");
    assertFalse(str.isEmpty(), "StrStack no longer empty as a String has been pushed");
  }
  
  @Test // Test 3
  void testPushAndPop() throws BadTypeException {
    str.push("Hello");
    assertEquals(str.pop(), "Hello", "The last String being Hello should be returned by pop()");
    assertEquals(str.size(), 0, "StrStack should be empty now after using pop");
  }
  
  @Test // Test 4
  void testPushAndPopMultiple() throws BadTypeException {
    str.push("Hello");
    str.push("Test");
    assertEquals(str.pop(), "Test", "Latest entry should be popped from StrStack");
    assertEquals(str.pop(), "Hello", "First entry should be popped from the StrStack");
    assertThrows(EmptyStackException.class, () -> str.pop(), "Can't pop from an empty stack");
    for (int i = 0; i < 300; i++) {
      str.push("Hello");
    }
    assertEquals(str.size(), 300, "After the for loop there should be 300 strings stored");
  }
  
  @Test // Test 5
  void testEmpty() {
    str.push("Hi");
    str.push("Hello");
    str.push("World");
    str.empty();
    assertEquals(str.size(), 0, "The StrStack should be completely empty and size set to 0");
  }

}
