package Expression.Parser;



import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.misc.NotNull;

import Expression.Constant;
import Expression.Expression;
import Expression.Operation;
import Expression.Operator;
import Expression.Variable;

import fr.blagnac.parser.expr.ExpressionBaseVisitor;
import fr.blagnac.parser.expr.ExpressionLexer;
import fr.blagnac.parser.expr.ExpressionParser;
import fr.blagnac.parser.expr.ExpressionParser.BinopContext;
import fr.blagnac.parser.expr.ExpressionParser.ExprContext;
import fr.blagnac.parser.expr.ExpressionParser.FullExprContext;
import fr.blagnac.parser.expr.ExpressionParser.ParenthContext;
import fr.blagnac.parser.expr.ExpressionParser.ValueContext;
import fr.blagnac.parser.expr.ExpressionParser.VarContext;

/**
 * A class providing a method to build a expression tree from an expression string.
 */
public class Builder extends ExpressionBaseVisitor<Expression> {
	
	protected Builder() {}

	@Override
	public Expression visitFullExpr(@NotNull FullExprContext ctx) {
		return visit(ctx.getChild(0));
	}

	@Override
	public Expression visitBinop(@NotNull BinopContext ctx) {
		Operator op = new Operator(ctx.getChild(1).getText());
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		return new Operation(op,left,right);
	}

	@Override
	public Expression visitParenth(@NotNull ParenthContext ctx) {
		return visit(ctx.getChild(1));
	}

	@Override
	public Expression visitVar(@NotNull VarContext ctx) {
		char x = ctx.VAR().getText().charAt(0);
		return new Variable(x);
	}

	@Override
	public Expression visitValue(@NotNull ValueContext ctx) {
		int n = new Integer(ctx.INT().getText());
		return new Constant(n);
	}
	
	/**
	 * Builds the tree representing an arithmetic expression given as input.
	 * @param txt The textual representation of the expression
	 * @return The tree representation of the expression
	 * @throws ParsingException The expression is invalid with respect to the grammar 
	 */
	public static Expression fromString(@NotNull String txt) throws ParsingException {
	       ExpressionLexer lex = new ExpressionLexer(new ANTLRInputStream(txt));
	       CommonTokenStream tokens = new CommonTokenStream(lex);
	       ExpressionParser parser = new ExpressionParser(tokens);
	       ExprContext tree;
	       try {
	    	   tree = parser.expr();
	    	   int parse_err = parser.getNumberOfSyntaxErrors();
	    	   if (parse_err > 0)
	    		   	throw new ParsingException(parse_err+" error have been encountered while parsing \""+txt+"\"");
	       } catch (RecognitionException e)  {
	    	   throw new ParsingException("An error have been encountered while parsing \""+txt+"\"",e);
	       }
	       Builder builder = new Builder();
	       return builder.visit(tree);
	}

}
