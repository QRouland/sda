
/**
 * Named expressions.
 * Example: x, y.
 */
public class Variable implements Expression, Symbol {
	/**
	 * The name of the variable.
	 */
	protected final char name;
	/**
	 * Construct a named expression (a variable) with a given name.
	 * @param x The name of the variable
	 */
	public Variable(char x) {
		name = x;
	}
}
