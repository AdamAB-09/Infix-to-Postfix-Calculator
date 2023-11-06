package calculator;

import java.util.EmptyStackException;

/**
 * Facade class in which only float values are stored and removes exceptions.
 * 
 * @author ZHAC004
 *
 */
public class NumStack {

  private Stack numStack = new Stack();

  /**
   * Returns the size of the NumStack.
   */
  public int size() {
    return numStack.size();
  }


  /**
   * Inserts the float value to the top of the NumStack.
   * 
   * @param f the float value being pushed into the NumStack
   */
  public void push(float f) {
    numStack.push(new Entry(f)); 
  }
  

  /**
   * Checks if the current NumStack doesn't contain any float values.
   * 
   * @return returns true if the size of stack is 0 otherwise false
   */
  public boolean isEmpty() {
    if (numStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }


  /**
   * Most recent float value added to the NumStack is removed and returned.
   * 
   * @return returns and removes the latest float value inserted in the NumStack
   * @throws BadTypeException thrown when a float value isn't used
   */
  public float pop() throws BadTypeException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    Entry value = numStack.pop();
    return value.getValue();
  }
  
  /**
   * Used to completely empty out the NumStack by popping all values.
   */
  public void empty() {
    while (!isEmpty()) {
      numStack.pop();
    }
  }


  

}
