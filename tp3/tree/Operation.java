import java.util.*;


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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((op == null) ? 0 : op.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
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
		Operation other = (Operation) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (op == null) {
			if (other.op != null)
				return false;
		} else if (!op.equals(other.op))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

	public String toString() {
		return "("+left.toString() +  op.toString() + right.toString()+")";
	}
	
	@Override
	public int evaluate(Map<Character, Integer> values)
			throws UnknownVariableException {
		switch(op.toString()){
		case "+" :
			return left.evaluate(values)+right.evaluate(values);
		case "-" :
			return left.evaluate(values)-right.evaluate(values);
		case "*" :
			return left.evaluate(values)*right.evaluate(values);
		case "/" :
			return left.evaluate(values)/right.evaluate(values);
		}
		return 0;
	}

	@Override
	public List<Symbol> rpn() {
		List<Symbol> retour = new LinkedList<Symbol>();
		retour.addAll(left.rpn());
		retour.addAll(right.rpn());
		retour.add(op);
		return retour;
	}
}
