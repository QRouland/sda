package Expression;



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
	public Operator(String name) {
		this.symbol = name;
	}
	
   	@Override
   	public String toString() {
   		return symbol;
   	}
	
   	/**
   	 * Evaluate the operation symbolized by the operator.
   	 * @param l The left operand
   	 * @param r The right operand
   	 * @return The result of the operation 
   	 */
	public int evaluate(int l, int r) {
		switch (symbol) {
		case "+": return l+r;
		case "-": return l-r;
		case "/": return l/r;
		case "*": return l*r;
		default: throw new RuntimeException();
		}
	}
	
	/**
	 * A precedence such that no operator can have it.
	 */
	public static final int maxPrecedence = Integer.MAX_VALUE;
	/**
	 * The precedence of the operator.
	 * @return The precedence of the operator.
	 */
   	public int precedence() {
		switch(symbol){
		case "+": case "-": return 6;
		case "*": case "/": return 4;
		default: throw new RuntimeException();
		}
   	}
	/**
	 * The precedence of the operator with respect to its left expression.
	 * @return The precedence of the operator.
	 */
	public int leftPrecedence() {
		return precedence();
	}
	/**
	 * The precedence of the operator with respect to its right expression.
	 * @return The precedence of the operator.
	 */
	public int rightPrecedence() {
		return precedence()-1;
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
