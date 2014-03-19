package Expression;



import java.util.Map;

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
	
	@Override
	public String toString() {
		return value + "";
	}
	@Override
	public String toString(int outerPrecedence) {
		return this.toString();
	}
	@Override
	public int evaluate(Map<Character,Integer> values) {
		return value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constant other = (Constant) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
