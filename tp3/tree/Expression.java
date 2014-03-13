import java.util.*;

/**
 * Interface for all the arithmetic expressions.
 */
public interface Expression {


/**
 * Evaluates an expression in a given environment.
 * @param values A mapping between the variable names and their effective values
 * @return The value of the expression
 * @throws UnknownVariableException A variable of the expression has no value in the environment
 */
public int evaluate(Map<Character,Integer> values) throws UnknownVariableException;


public List<Symbol> rpn();

}
