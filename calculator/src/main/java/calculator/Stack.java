package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * An implementation of the stack data structure explicitly for Entry objects.
 *
 * @author ZHAC004
 */
public class Stack {

  private int size = 0; // 0 Elements are within the ArrayList originally so size starts from 0
  private ArrayList<Entry> value = new ArrayList<Entry>(); /* This ArrayList will be able to store
  * multiple Entry objects in order to push and pop
  */
  

  /**
   * Returns the current size of the stack.
   */
  public int size() {
    return size;
  }

  /**
   * Inserts the Entry object to the top of the Stack. 
   * 
   * @param e the Entry object that wants to be added to the ArrayList
   */
  public void push(Entry e) {
    value.add(e); // The add method will take the entry and put into the ArrayList
    size++; // Size of the ArrayList needs to increment by 1 when pushing an object
  }


  /**
   * Return the latest entry and then remove it from the stack.
   *
   * @return returns the previous (last) entry inside the ArrayList
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return value.remove(--size); /* The size decrements by 1 and is set as the new size due to
    * the ArrayList having one less element from popping
    */
  }


  /**
   * Acts as a getter method to get top element of the stack without altering values.
   * 
   * @return returns the top element in the ArrayList
   */ 
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return value.get(size - 1); // Doesn't alter the size, instead gets the most recent element
  }

}
