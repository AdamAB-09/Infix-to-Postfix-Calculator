package calculator;

import java.util.EmptyStackException;

/**
 * Facade class in which only Strings are passed into the stack and removes exceptions.
 * 
 * @author ZHAC004
 *
 */
public class StrStack {

  private Stack strStack = new Stack();

  /**
   * Returns the size of the StrStack.
   */
  public int size() {
    return strStack.size();
  }

  /**
   * Puts the String to the top of the StrStack.
   * 
   * @param str the String being inserted into the StrStack
   */
  public void push(String str) {
    strStack.push(new Entry(str));
  }

  /**
   * Checks to see if the StrStack currently contains 0 elements within it.
   * 
   * @return returns true if size of the stack is 0 otherwise false
   */
  public boolean isEmpty() {
    if (strStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Most recent String inserted into the StrStack is removed and returned.
   * 
   * @return returns and removes the latest String added into the StrStack
   * @throws BadTypeException thrown when String isn't used
   */
  public String pop() throws BadTypeException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    Entry entry = strStack.pop();
    return entry.getString();
  }
  
  /**
   * Used to completely empty out the StrStack by popping all values.
   */
  public void empty() {
    while (!isEmpty()) {
      strStack.pop();
    }
  }


}

