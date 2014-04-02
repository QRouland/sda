package src.test;

import org.junit.BeforeClass;

import src.intset.IntegerSet;
import src.intset.RTIntegerSet;

/**
 * Base class for testing an implementation of IntegerSet.
 */
public abstract class IntegerSetTest {

	/**
	 * Static method defining the class under test.
	 * This method returns a new empty set. 
	 * @return An empty set belonging to the class under test.
	 */
	protected static IntegerSet underTest() {
		return new RTIntegerSet();
	}
	
	/**
	 * Checks that the method underTest(). 
	 * @throws AssertionError If underTest() does not behave well
	 */
	@BeforeClass
	public static void checkUnderTest() {
		IntegerSet s1 = underTest();
		IntegerSet s2 = underTest();
		if (s1 == null || s2 == null) {
			throw new AssertionError("method underTest() returned a null reference");
		}
		if (s1 == s2) {
			throw new AssertionError("method underTest() did not returned a new set");
		}
	}
	
	/**
	 * null
	 */
	public static void main(String[] args) {
		try {
			checkUnderTest();
			System.out.println("Set creation seems OK");
			System.out.println("(1) Run Test_add to check method add");
			System.out.println("(2) Run Coverage to check all methods");
		} catch (AssertionError e) {
			System.err.println("Set creation is not OK");
			e.printStackTrace();
		}
	}

}
