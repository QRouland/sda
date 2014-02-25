
/**
 * Thrown to indicate that a computation cannot succeed due to
 * the lack of information on a given variable.
 */
public class UnknownVariableException extends Exception {

	private static final long serialVersionUID = 1L;

	public UnknownVariableException(String message) {
		super(message);
	}

}
