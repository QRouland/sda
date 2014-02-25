
/**
 * Binary arithmetic operators.
 * Examples: +, -, *.
 */
public class Operator implements Symbol {
	/**
	 * The symbol of the operator
	 */
	protected final String symbol;
	/**
	 * Construct an operator using its textual representation.
	 * @param symbol The symbol of the operator
	 */
	public Operator(String symbol) {
		this.symbol = symbol;
	}
}
