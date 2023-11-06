package calculator;

/**
 * The types in which the calculator may process arithmetic calculations.
 * 
 * @author ZHAC004
 *
 */
public enum OpType { // The calculator can switch between Postfix and Infix mode
  
  POSTFIX("Postfix"),
  INFIX("Infix");
  
  public String opType;
  
  /**
   * A private constructor that takes the associated String for the constant.
   * 
   * @param opType string associated with the constant
   */
  private OpType(String opType) {
    this.opType = opType;
  }
  
  /**
   * Returns the constant as a String.
   */
  public final String toString() {
    return opType;
  }
  
  
  
  

}
