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


	@Override
	public String toString() {
		return String.valueOf(value);
	}


	@Override
	public int evaluate(Map<Character, Integer> values)
			throws UnknownVariableException {
		// TODO Auto-generated method stub
		return 0;
	}
}
