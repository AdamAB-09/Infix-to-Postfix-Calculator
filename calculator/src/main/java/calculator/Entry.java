package calculator;

/**
 * A wrapper class to store strings, numbers and symbols.
 * 
 * @author ZHAC004
 */
public class Entry {

  private Float number; // Entry is able to take a Float value
  private String str;   // Entry is able to take a String value
  private Symbol other; // Entry is able to take a Symbol value
  private Type type; // Used to determine the Type of the Entry object 

  /**
   * Constructor for an Entry object to accept float values passed into its parameter.
   * 
   * @param value the float to be passed to the constructor
   */
  public Entry(float value) {
    number = value;
    type = Type.NUMBER; // Set type to NUMBER when an Entry object with a float value is created
  }

  /**
   * Constructor for an Entry object to accept any string value passed into its parameter.
   * 
   * @param string the string to be passed to the constructor
   */
  public Entry(String string) {
    str = string;
    type = Type.STRING; // Set type to STRING when an Entry object with a string is created
  }

  /**
   * Constructor for an Entry object to accept the type Symbol passed into its parameter.
   * 
   * @param which the Symbol type being passed to the constructor
   */
  public Entry(Symbol which) {
    other = which;
    type = Type.SYMBOL; // Set type to SYMBOL when an Entry object with a Symbol value is created
  }

  /**
   * A getter method to get the type of data for Entry.
   * 
   * @return returns the type of the Entry object
   */
  public Type getType() {
    return type;
  }


  /**
   * A getter method to get the string passed into the parameter of the Entry object.
   * 
   * @return returns the string for the Entry object
   * @throws BadTypeException to be thrown when Entry is not a string and getString is called
   */
  public String getString() throws BadTypeException {
    if (str == null) { // This block of code will be executed if there is no String for the object
      throw new BadTypeException("Incorrect type being used! String type must be used.");
    } else {
      return str;
    }
  }

  /**
   * A getter method to get the symbol passed into the parameter of the Entry object.
   * 
   * @return returns the symbol for the Entry object
   * @throws BadTypeException to be thrown when Entry does not contain Symbol and getSymbol is
   *         called
   *         
   *         
   *         
   */
  public Symbol getSymbol() throws BadTypeException {
    if (other == null) { // This block of code will be executed if there is no Symbol for the object
      throw new BadTypeException("Incorrect type being used! Symbol type must be used.");
    } else {
      return other;
    }
  }


  /**
   * A getter method to get the float value passed into the parameter of the Entry object.
   * 
   * @return returns the float value of the Entry object
   * @throws BadTypeException to be thrown when Entry does not contain a float and getValue is
   *         called
   *         
   *         
   *         
   */
  public float getValue() throws BadTypeException {
    if (number == null) { // This block of code will be executed if there is no float for the object
      throw new BadTypeException("Incorrect type being used! Float type must be used.");
    } else {
      return number;
    }
  }


  /**
   * Create a newly formatted toString method to put all instance variables except type into a
   * string.
   */
  @Override
  public String toString() {
    return (number != null ? number : "") + (str != null ? str : "") + (other != null ? other : "");
    /*
     * When an Entry is created with either String, Float or Symbol, the other instance variables
     * will be null thus shouldn't be printed out
     */
  }


  /**
   * Generate a custom hashCode method to distinguish different Entry objects via an int value.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result = prime * result + ((other == null) ? 0 : other.hashCode());
    result = prime * result + ((str == null) ? 0 : str.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    return result;
  }

  /**
   * Custom equals method in order to compare if two Entry objects are exactly the same in terms
   * of the contents passed into the parameter.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Entry)) {
      return false;
    }
    Entry other = (Entry) obj;
    if (number == null) {
      if (other.number != null) {
        return false;
      }
    } else if (!number.equals(other.number)) {
      return false;
    }
    if (this.other != other.other) {
      return false;
    }
    if (str == null) {
      if (other.str != null) {
        return false;
      }
    } else if (!str.equals(other.str)) {
      return false;
    }
    if (type != other.type) {
      return false;
    }
    return true;
  }

}


