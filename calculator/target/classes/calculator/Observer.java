package calculator;

/**
 * Functional type for an observer notification.
 * 
 * @author ZHAC004
 *
 */
@FunctionalInterface
public interface Observer {
  
  /**
   * Used to inform the Observer of any changes.
   */
  public void tell();

}
