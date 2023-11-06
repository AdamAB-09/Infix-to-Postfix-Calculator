package calculator;

import java.util.EmptyStackException;

/**
 * Facade class for Symbols to be stored into a stack and removes exceptions.
 * 
 * @author ZHAC004
 *
 */
public class OpStack {

  private Stack opStack = new Stack();

  /**
   * Inserts the Symbol to the top of the OpStack.
   * 
   * @param sym the Symbol being inserted into the OpStack
   */
  public void push(Symbol sym) {
    opStack.push(new Entry(sym));
  }

  /**
   * Returns the size of the NumStack.
   */
  public int size() {
    return opStack.size();
  }
  
  /**
   * Gets the last Symbol pushed onto the OpStack, being at the top.
   * 
   * @return returns the Symbol top of the OpStack
   * @throws BadTypeException thrown when wrong type is used
   */
  public Symbol top() throws BadTypeException {
    Entry entry = opStack.top();
    return entry.getSymbol();
  }

  /**
   * Checks if the current OpStack has 0 Symbol elements within it.
   * 
   * @return returns true if size of the OpStack is 0 otherwise returns false
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Most recent Symbol on the top of the StrStack is removed and returned.
   * 
   * @return returns and removes the latest Symbol added into OpStack
   * @throws BadTypeException thrown when Symbol isn't used
   */
  public Symbol pop() throws BadTypeException {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    Entry entry = opStack.pop();
    return entry.getSymbol();
  }

}
