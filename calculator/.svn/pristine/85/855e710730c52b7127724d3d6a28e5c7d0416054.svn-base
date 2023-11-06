package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TestEntry {
  
  private Entry entry;
  private Entry entry2;
  private Entry entry3;
  private Entry entry4;

  /*
  @Test 
  void testConstructors() { 
    entry = new Entry(20.0f);
    assertEquals(entry.number, 20.0f, "Test to see if new entry is able to take a float of 20.0f");
    entry = new Entry("Hello.");
    assertEquals(entry.str, "Hello.", "Test to see if entry is able to take string Hello. ");
    entry = new Entry(Symbol.DIVIDE);
    assertEquals(entry.other, Symbol.DIVIDE, "Test to see if entry can take symbol DIVIDE");
  }
  * As getter methods are created later on this meant instance variables were made private, thus
  * making this test void as they can't be used.
  */

  @Test // Test 1
  void testGetString() throws BadTypeException { /* Return a string for only
    /Entry object with string type 
    */
    entry = new Entry(32.5f);
    assertThrows(BadTypeException.class, () -> entry.getString(),
        "You cannot use getString method for float vlaues");
    entry = new Entry("Hello");
    assertEquals(entry.getString(), "Hello",
        "The getString method should return Hello");
  }

  @Test // Test 2
  void testGetSymbol() throws BadTypeException { /* Return the symbol for only
    /Entry object with symbol type 
    */
    entry = new Entry("Expression");
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "You cannot use getSymbol method for a string");
    entry = new Entry(Symbol.DIVIDE);
    assertEquals(entry.getSymbol(), Symbol.DIVIDE,
        "getSymbol method should return symbol passed into parameter");
  }

  @Test // Test 3
  void testGetValue() throws BadTypeException { /* Return the value with only Entry
    /object with float type
    */
    entry = new Entry(Symbol.TIMES);
    assertThrows(BadTypeException.class, () -> entry.getValue(),
        "You cannot use getValue method when symbol is used");
    entry = new Entry(2.4f);
    assertEquals(entry.getValue(), 2.4f, "2.4f should be returned by the getValue method");
    entry = new Entry(0.0f);
    assertEquals(entry.getValue(), 0.0f,
        "0.0f should be valid input for getValue without BadTypeException being thrown"); /* Change
    float into object Float to pass test, as null is default value and 0.0f can be used. */
  }
  
  @Test // Test 4
  void testGetType() { // To pass this test, need to set the type in each constructor for Entry
    entry = new Entry("Hello");
    assertEquals(entry.getType(), Type.STRING,
        "Type.STRING should be returned when entry is a string");
    entry = new Entry(2.5f);
    assertEquals(entry.getType(), Type.NUMBER,
        "Type.NUMBER should be returned when entry is a float");
    entry = new Entry(Symbol.LEFT_BRACKET);
    assertEquals(entry.getType(), Type.SYMBOL,
        "Type.SYMBOL should be returned when entry is a symbol");
        
  }
  
  @Test // Test 5
  void testToString() { /*Checking if the format of the toString method is 
  correctly formatted for any type by comparing strings.
  */
    entry = new Entry(Symbol.PLUS);
    assertEquals(entry.toString(), "+");
    entry = new Entry(2.9f);
    assertEquals(entry.toString(), "2.9");
    entry = new Entry("Morning");
    assertEquals(entry.toString(), "Morning");
  }
  
  @Test // Test 6
  void testHashAndEquals() { // To pass test need to correctly implement both methods
    entry = new Entry(35.4f); // Create 4 Entry objects with different types
    entry2 = new Entry(58.4f); // Have different float value for entry2 to compare with entry
    entry3 = new Entry(Symbol.DIVIDE);
    entry4 = new Entry("Test"); 
    assertFalse(entry.equals(entry2),
        "Two different float values should make equals method return false");
    assertFalse(entry.equals(entry3),
        "Float and symbol type should make equals method return false");
    assertFalse(entry3.equals(entry4),
        "Symbol and string type should make equals method return false");
    assertNotEquals(entry.hashCode(), entry2.hashCode(),
        "Hashcode method should return false if two objects don't have same value");
    entry = new Entry(58.4f); // Make entry have same float value as entry2 to test true
    assertTrue(entry.equals(entry2),
        "Two entry objects with same float value should return true for equals method");
    assertEquals(entry.hashCode(), entry2.hashCode(),
        "Same hashcode value for two objects with same float value");
    entry = new Entry("Test"); // Make entry have same string value as entry4
    assertTrue(entry.equals(entry4),
        "Equals method should return true as both objects have same string value");
    assertEquals(entry.hashCode(), entry4.hashCode(),
        "Hashcode method should return same value for both entry objects");
  }

}
