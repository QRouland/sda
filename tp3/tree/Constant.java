
/**
 * Constant expressions.
 * Example: 1.
 */
public class Constant implements Expression, Symbol {
	/**
	 * The value of the constant.
	 */
	protected final int value;
	/**
	 * Constructs a constant expression of a given value.
	 * @param n The value of the constant
	 */
	public Constant(int n) {
		value = n;
	}
}
