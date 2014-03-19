package Expression;



import java.util.Map;

/**
 * Interface for all the arithmetic expressions.
 */
public interface Expression {
	/**
	 * Evaluates an expression in a given environment.
	 * @param values A mapping between the variable names and their effective value
	 * @return The value of the expression
	 * @throws UnknownVariableException A variable of the expression has no value in the environment
	 */
	public int evaluate(Map<Character,Integer> values) throws UnknownVariableException;
	
	/**
	 * Prints the expression knowing the precedence of the operator above it.
	 * Parentheses are added only if the precedence of the expression is higher.
	 * @param outerPrecedence The precedence of the operator above it.
	 * @return A string representing the expression
	 */
	public String toString(int outerPrecedence);
}
