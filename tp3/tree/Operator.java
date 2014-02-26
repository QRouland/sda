
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
	
	@Override
	public String toString() {
		return symbol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
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
		Operator other = (Operator) obj;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}


}
