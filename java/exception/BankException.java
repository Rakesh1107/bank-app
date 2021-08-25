
package exception;

public class BankException extends Throwable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BankException(String message) {
        super(message);
    }
    public BankException(String message, Exception exception) {
        super(message,exception);
    }
}