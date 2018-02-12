/**
 * This is an unchecked expression because if an incorrect square was being
 * initialized it would not be easily recoverable from 
 * @author Saivardhan Mada
 * @version 1.1
 */
public class InvalidSquareException extends RuntimeException {
  /**
   * sends message to super class and is-a throwable
   *
   * @param message string message for error that is recieved
   */
    public InvalidSquareException(String message) {
        super(message);
    }
}
