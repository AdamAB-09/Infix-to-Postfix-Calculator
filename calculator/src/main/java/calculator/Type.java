package calculator;

/**
 * Enum to classify the type of data being used for the calculator.
 * 
 * @author ZHAC004
 */
public enum Type { // The constants below are the four different types that will be accepted
  NUMBER("Number"),
  SYMBOL("Symbol"),
  STRING("String"),
  INVALID("Invalid expression!");

  public String type; // type would be the string inside the parentheses of the constants

  /**
   * A private constructor which takes the associated string for the constant.
   * 
   * @param type string associated with the constant within the class
   */
  private Type(String type) {
    this.type = type;
  }

  /**
   * Returns the constant as a string output.
   */
  public final String toString() {
    return type;
  }
}
