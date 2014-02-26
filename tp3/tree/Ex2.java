
public class Ex2
{
    public static void main (String[] args)
    {
    	Expression lol1 = null, lol2;
    	try { 
    		lol1 = Builder.fromString("x+1");
    		lol2 = (Expression)new Operation(new Operator("+"), new Variable('x'), new Constant('1'));
    		lol2 = Builder.fromString("x+1"); 
	    	if(lol1.equals(lol2))
	    		System.out.print("Good");
    	} catch (ParsingException e) {}
    }
}
