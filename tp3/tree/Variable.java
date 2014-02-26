import java.util.Map;


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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name;
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
		Variable other = (Variable) obj;
		if (name != other.name)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return String.valueOf(name);
	}


	@Override
	public int evaluate(Map<Character, Integer> values)
			throws UnknownVariableException {
		// TODO Auto-generated method stub
		return 0;
	}
}
