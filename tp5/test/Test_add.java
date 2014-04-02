package src.test;

import static org.junit.Assert.*;

import src.intset.IntegerSet;
import src.intset.Range;

import java.util.List;

import org.junit.Test;


/**
 * Tests the empty set constructor and the add method of a class implementing IntegerSet.
 * @see IntegerSet
 */
public class Test_add extends IntegerSetTest {
	
	/**
	 * Checks that the ranges of the set under test are the same
	 * than those of the reference set.
	 * @param ref The reference set
	 * @param impl The set under test
	 * @param hist Information about the history of operations
	 */
	public static void assertSameSets(IntegerSet ref, IntegerSet impl, String hist) {
		List<Range> lref = ref.toRanges();
		List<Range> limpl;
		try {
			limpl = impl.toRanges();
		} catch (Throwable e) {
			throw new AssertionError(hist+" should have led to ranges "+lref+
					" but method toRange failed: ",e);
		}
		assertEquals("Incorrect set content after operations +"+hist,lref,limpl);
	}
	
	/**
	 * Performs the test of adding several integers to a new empty set.
	 * @param elements The array of integers to add (the order is respected)
	 */
	public static void test_add_array(int[] elements) {
		String hist = "emptySet; ";
		IntegerSet ref = new ReferenceIntegerSet();
		IntegerSet impl;
		try { // Constructor
			impl = underTest();
		}
		catch (Throwable e) {
			throw new AssertionError("Set creation failed",e);
		}
		for(int x : elements) {
			hist += "add "+x+"; ";
			boolean ref_result = ref.add(x);
			boolean impl_result;
			try { // Add method
				impl_result = impl.add(x);
			}
			catch (Throwable e) {
				throw new AssertionError(hist+" led to an exception",e);
			}
			assertSameSets(ref,impl,hist);
			assertEquals("The last operation of "+hist+" returned the wrong result",
					ref_result,impl_result);
		}
	}
	
	@Test
	public void test_add_1_9() {
		test_add_array(new int[]{1,2,3,4,5,6,7,8,9});
		test_add_array(new int[]{1,3,5,7,9,2,4,6,8});
		test_add_array(new int[]{9,8,7,6,5,4,3,2,1});
		test_add_array(new int[]{9,7,5,3,1,8,6,4,2});
		test_add_array(new int[]{1,9,2,8,3,7,4,6,5});
	}
	
	@Test
	public void test_add_1_9_twice() {
		test_add_array(new int[]{1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9});
		test_add_array(new int[]{1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1});
		test_add_array(new int[]{9,8,7,6,5,4,3,2,1,1,2,3,4,5,6,7,8,9});
		test_add_array(new int[]{9,8,7,6,5,4,3,2,1,9,8,7,6,5,4,3,2,1});
		test_add_array(new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9});
	}

}
