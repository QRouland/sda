package Expression.Tests;
import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import Expression.Expression;
import Expression.Parser.Builder;
import Expression.Parser.ParsingException;

/**
 * A JUnit 4 unit test class which verifies that arithmetic expression are converted to correct strings.
 */
public class TestToString {

	protected static String[] exprs = {
			 "1",
			 "100",
			 "x",
			 "1+x",
			 "(a+b)+c",
			 "a+(b+c)",
			 "a*b+c",
			 "a+b*c",
			 "(a+b)*c",
			 "a*(b+c)",
			 "a-b",
			 "a/b"
			};
	
	protected Map<String,Expression> assoc;
	
	public TestToString() {}

	@Before
	public void setUp() throws Exception {
		assoc = new LinkedHashMap<String,Expression>();
		for(String s : exprs) {
			assoc.put(s, Builder.fromString(s));
		}
	}

	@Test
	public void test() {
		for(Entry<String,Expression> entry : assoc.entrySet()) {
			String original_s = entry.getKey();
			Expression original_t = entry.getValue();
			String new_s = original_t.toString();
			try {
				Expression new_t = Builder.fromString(new_s);
				assertEquals("The trees of "+original_s+" and "+new_s+" should be the same",original_t,new_t);
			}
			catch (ParsingException e) {
				fail(original_s+" have been printed as "+new_s+" which could not be decoded");
			}
		}
	}

}
