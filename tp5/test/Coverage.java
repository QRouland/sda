package src.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import src.intset.IntegerSet;

import src.intset.Range;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * JUnit 4 test class for testing all the methods of an implementation
 * of IntegerSet. Warning: each method is only tested on one example.
 */
public class Coverage extends IntegerSetTest {
	
	/**
	 * The set under test.
	 */
	protected IntegerSet mySet;
	/**
	 * The reference set.
	 */
	protected ReferenceIntegerSet refSet;
	
	/**
	 * Setup utility. Should lead to [1..3;5] when applied to an empty set.
	 * @param The set to fill.
	 */
	public static void fillSet(Set<Integer> x) {
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(5);
	}
	
	/**
	 * Checks that the coverage test can take place.
	 * @throws Exception If the implementation cannot support coverage test.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		List<Range> refList, myList;
		String abortMsg = "Cannot perform coverage tests";
		
		/* Building the reference set */
		ReferenceIntegerSet refSet = new ReferenceIntegerSet();
		fillSet(refSet);
		refList = refSet.toRanges();
		
		/* Building the set under test */
		IntegerSet mySet;
		try {
			mySet = underTest();
			fillSet(mySet);
			myList = mySet.toRanges();
		} catch (Throwable e) {
			throw new Exception(abortMsg+": basic set creation failed",e);
		}
		
		/* Checking that contents are equal */
		if (!myList.equals(refList)) {
			throw new Exception(abortMsg+": building set "+refList+" led to "+myList);
		}
	}
	
	/**
	 * Setup the initial sets.
	 */
	@Before
	public void setUp() {
		refSet = new ReferenceIntegerSet();
		fillSet(refSet);
		mySet = underTest();
		fillSet(mySet);
	}

	/**
	 * Fail the test due to a given exception or error.
	 * @param e The original failure.
	 */
	private static void methodFailed(Throwable e) {
		String reason;
		if(e instanceof UnsupportedOperationException) {
			reason = "Method not supported (yet)";
		} else if (e instanceof AssertionError) {
			throw (AssertionError) e;
		} else {
			reason = "Method failed";
		}
		throw new AssertionError(reason,e);
	}
	/**
	 * Checks that the sets agrees on their content.
	 */
	protected void checkEquals() {
		List<Range> refList = refSet.toRanges();
		try {
			List<Range> myList = mySet.toRanges();
			assertEquals("Incorrect set content after operation.",refList,myList);
		} catch (Throwable e) { throw new AssertionError(
				"Set content after operation should have been "+refList
				+" but method toRange() failed",e); }
	}
	/**
	 * Checks that the sets agrees on their content and result.
	 * @param ref The reference result
	 * @param my The result given by the class under test
	 */
	protected void checkEquals(Object ref, Object my) {
		checkEquals();
		assertEquals("Incorrect operation return value.",ref,my);
	}
	/**
	 * Checks that the sets agrees on their content and result (special case of array).
	 * @param ref The reference result (an array)
	 * @param my The result given by the class under test (an array)
	 */
	protected void checkArrayEquals(Object[] ref, Object[] my) {
		checkEquals();
		assertArrayEquals("Incorrect operation return value."+ref,ref,my);
	}
	
	/* add */
	public static boolean run_add(IntegerSet x) {
		return x.add(6);
	}
	@Test
	public void test_add() {
		Object ref_result, my_result;
		ref_result = run_add(refSet);
		try {
			my_result = run_add(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* addAll */
	public static void run_addAll(IntegerSet x) {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(5);
		c.add(6);
		c.add(7);
		c.add(8);
		x.addAll(c);
	}
	@Test
	public void test_addAll() {
		run_addAll(refSet);
		try {
			run_addAll(mySet);
			checkEquals();
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* addRange */
	public static boolean run_addRange(IntegerSet x) {
		return x.addRange(new Range(5,8));
	}
	@Test
	public void test_addRange() {
		Object ref_result, my_result;
		ref_result = run_addRange(refSet);
		try {
			my_result = run_addRange(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* clear */
	public static void run_clear(IntegerSet x) {
		x.clear();
	}
	@Test
	public void test_clear() {
		run_clear(refSet);
		try {
			run_clear(mySet);
			checkEquals();
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* contains */
	public static boolean run_contains(IntegerSet x) {
		return x.contains(2);
	}
	@Test
	public void test_contains() {
		Object ref_result, my_result;
		ref_result = run_contains(refSet);
		try {
			my_result = run_contains(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* containsAll */
	public static boolean run_containsAll(IntegerSet x) {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(5);
		return x.containsAll(c);
	}
	@Test
	public void test_containsAll() {
		Object ref_result, my_result;
		ref_result = run_containsAll(refSet);
		try {
			my_result = run_containsAll(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* containsRange */
	public static boolean run_containsRange(IntegerSet x) {
		return x.addRange(new Range(2,3));
	}
	@Test
	public void test_containsRange() {
		Object ref_result, my_result;
		ref_result = run_containsRange(refSet);
		try {
			my_result = run_containsRange(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* equals */
	public static boolean run_equals(IntegerSet x) {
		Set<Integer> other = new HashSet<Integer>();
		fillSet(other);
		return x.equals(other);
	}
	@Test
	public void test_equals() {
		Object ref_result, my_result;
		ref_result = run_equals(refSet);
		try {
			my_result = run_equals(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* hashCode */
	public static int run_hashCode(IntegerSet x) {
		return x.hashCode();
	}
	@Test
	public void test_hashCode() {
		Object ref_result, my_result;
		ref_result = run_hashCode(refSet);
		try {
			my_result = run_hashCode(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* isEmpty */
	public static boolean run_isEmpty(IntegerSet x) {
		return x.isEmpty();
	}
	@Test
	public void test_isEmpty() {
		Object ref_result, my_result;
		ref_result = run_isEmpty(refSet);
		try {
			my_result = run_isEmpty(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* iterator */
	public static List<Integer> run_iterator(IntegerSet x) {
		List<Integer> list = new ArrayList<Integer>();
		for(Integer i : x) {
			list.add(i);
		}
		return list;
	}
	@Test
	public void test_iterator() {
		Object ref_result, my_result;
		ref_result = run_iterator(refSet);
		try {
			my_result = run_iterator(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* remove */
	public static boolean run_remove(IntegerSet x) {
		return x.remove(3);
	}
	@Test
	public void test_remove() {
		Object ref_result, my_result;
		ref_result = run_remove(refSet);
		try {
			my_result = run_remove(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* removeAll */
	public static boolean run_removeAll(IntegerSet x) {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(5);
		c.add(6);
		return x.removeAll(c);
	}
	@Test
	public void test_removeAll() {
		Object ref_result, my_result;
		ref_result = run_removeAll(refSet);
		try {
			my_result = run_removeAll(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* removeRange */
	public static boolean run_removeRange(IntegerSet x) {
		return x.removeRange(new Range(3,8));
	}
	@Test
	public void test_removeRange() {
		Object ref_result, my_result;
		ref_result = run_removeRange(refSet);
		try {
			my_result = run_removeRange(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* retainAll */
	public static boolean run_retainAll(IntegerSet x) {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(5);
		c.add(6);
		return x.retainAll(c);
	}
	@Test
	public void test_retainAll() {
		Object ref_result, my_result;
		ref_result = run_retainAll(refSet);
		try {
			my_result = run_retainAll(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* retainRange */
	public static boolean run_retainRange(IntegerSet x) {
		return x.retainRange(new Range(3,8));
	}
	@Test
	public void test_retainRange() {
		Object ref_result, my_result;
		ref_result = run_retainRange(refSet);
		try {
			my_result = run_retainRange(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* size */
	public static int run_size(IntegerSet x) {
		return x.size();
	}
	@Test
	public void test_size() {
		Object ref_result, my_result;
		ref_result = run_size(refSet);
		try {
			my_result = run_size(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* toArray (no parameters) */
	public static Object[] run_toArray0(IntegerSet x) {
		return x.toArray();
	}
	@Test
	public void test_toArray0() {
		Object[] ref_result, my_result;
		ref_result = run_toArray0(refSet);
		try {
			my_result = run_toArray0(mySet);
			checkArrayEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* toArray (one parameter) */
	public static Integer[] run_toArray1(IntegerSet x) {
		return x.toArray(new Integer[0]);
	}
	@Test
	public void test_toArray1() {
		Object[] ref_result, my_result;
		ref_result = run_toArray1(refSet);
		try {
			my_result = run_toArray1(mySet);
			checkArrayEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* toRanges */
	public static List<Range> run_toRanges(IntegerSet x) {
		return x.toRanges();
	}
	@Test
	public void test_toRanges() {
		Object ref_result, my_result;
		ref_result = run_toRanges(refSet);
		try {
			my_result = run_toRanges(mySet);
			checkEquals(ref_result,my_result);
		} catch (Throwable e) { methodFailed(e); }
	}
	
	/* toString */
	public static void run_toString(IntegerSet x) {
		x.toString();
	}
	@Test
	public void test_toString() {
		run_toRanges(refSet);
		try {
			run_toRanges(mySet);
			checkEquals();
		} catch (Throwable e) { methodFailed(e); }
	}
}
