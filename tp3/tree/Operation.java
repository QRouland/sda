
/**
 * Binary arithmetic operations.
 * Examples: x+1, (2*y)+5.
 */
public class Operation implements Expression {
	/**
	 * The operator.
	 */
	protected final Operator op;
	/**
	 * The expression on the left side of the operator.
	 */
	protected final Expression left;
	/**
	 * The expression on the right side of the operator.
	 */
	protected final Expression right;
	/**
	 * Constructs an binary operation by combining two expressions using the provided operator.
	 * @param op The operator
	 * @param left The expression on the left side of the operator
	 * @param right The expression on the right side of the operator
	 */
	public Operation(Operator op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
}
