package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestStack {

  private Stack stack;
  private Entry entry;
  private Entry entry2;
  private Entry entry3;

  @BeforeEach
  void startUp() { // Set up a new stack and 3 entry objects before each test
    stack = new Stack();
    entry = new Entry(5.6f);
    entry2 = new Entry("Testing");
    entry3 = new Entry(Symbol.PLUS);
  }


  @Test // Test 1
  void testSize() { //0 is initialised to the size variable in stack to pass test
    assertEquals(stack.size(), 0, "When creating a stack the initial size should be 0");
  }

  @Test // Test 2
  void testPush() { // To pass need to increase the value of the stack by one each time push is used
    stack.push(entry);
    assertEquals(stack.size(), 1, "Pushing a value should increase the stack by one");
    stack.push(entry2);
    assertEquals(stack.size(), 2, "Pushing another value should increase the stack to two");
  }

  @Test // Test 3
  void testEmptyStack() { // When size is 0 the EmptyStackException should be thrown
    assertThrows(EmptyStackException.class, () -> stack.pop(), "Can't pop from an empty stack");
  }

  @Test // Test 4
  void testPop() { // Reduce the variable size by one after popping to pass the test
    stack.push(entry);
    stack.pop();
    assertEquals(stack.size(), 0, "Pushing then popping should have an empty stack");
  }

  @Test // Test 5
  void pushAndPop() { //Pass test > need to create value variable in stack that stores pushed entry
    stack.push(entry);
    assertEquals(stack.pop(), entry, "Popping after pushing entry should return the entry");
    assertEquals(stack.size(), 0, "Stack should be 0 again after popping");
    stack.push(entry2);
    assertEquals(stack.pop(), entry2,
        "Pushing and popping a new entry object now should return entry2");
  }

  @Test // Test 6
  void testPushThrice() { // Create a fixed size array to push more than once and pass test
    stack.push(entry);    
    stack.push(entry2);   
    stack.push(entry3);
    assertEquals(stack.pop(), entry3, "Popping should return last int being pushed being 4");
    assertEquals(stack.pop(), entry2,
        "2nd pop should return second to last int being pushed being 3");
    assertEquals(stack.pop(), entry, "Last pop should return first int being pushed being 2");
    assertThrows(EmptyStackException.class, () -> stack.pop(), "Can't pop from an empty stack");
  }

  @Test // Test 7
  void testPushMany() { // Switch to ArrayList as it's dynamic and to pass test
    for (int i = 0; i < 500; i++) {
      stack.push(new Entry(i));
    }
    assertEquals(stack.size(), 500, "500 elements should be stored inside the stack");
  }

  @Test // Test 8
  void testTop() { // top() needs to reduce size by 1 and return that entry to pass test
    assertThrows(EmptyStackException.class, () -> stack.top(), "Can't use top on an empty Stack!");
    stack.push(entry);
    stack.push(entry2);
    stack.push(entry3);
    assertEquals(stack.top(), entry3,
        "Last element added to stack should be returned, in this case entry3");
  }
  
  @Test // Test 9
  void testTopTwice() { // Use size - 1 instead in top(), so size value itself isn't changed
    stack.push(entry);
    stack.push(entry2);
    assertEquals(stack.top(), entry2, "Top of the stack should be entry2 as it was last push");
    stack.push(entry3);
    assertEquals(stack.top(), entry3, "New top of the stack should be entry3 as it was last push");
  }

  @Test // Test 10
  void testPushManyAndTop() { // Test to see if top works even with many elements in the mix
    for (int i = 0; i < 500; i++) {
      stack.push(new Entry(i));
      stack.top();
    }
    stack.push(entry);
    assertEquals(stack.top(), entry, "Top of the stack is entry as it was last push");
  }

}
