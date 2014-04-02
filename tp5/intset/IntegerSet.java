package src.intset;

import java.util.List;
import java.util.Set;

/**
 * An interface describing sets of integers.
 * This interface extends the interface Set&lt;Integer&gt; and
 * adds new methods relative to ranges.
 */
public interface IntegerSet extends Set<Integer> {
	/**
	 * Generates the sorted sequence of maximal ranges of integer contained in the set.
	 * @return A list of ranges
	 */
	public List<Range> toRanges();
	/**
	 * Add all the integers of a given range to the set.
	 * @param r The range of integer to add
	 * @return true if the operation modified the set, false otherwise
	 */
	public boolean addRange(Range r);
	/**
	 * Remove all the integers of a given range from the set.
	 * @param r The range of integer to remove
	 * @return true if the operation modified the set, false otherwise
	 */
	public boolean removeRange(Range r);
	/**
	 * Retain in a set only the integer of a given range.
	 * @param r The range of integer to retain
	 * @return true if the operation modified the set, false otherwise
	 */
	public boolean retainRange(Range r);
	/**
	 * Checks if a given range of integers is contained in the set.
	 * @param r The range to search
	 * @return true if all the elements of the range are contained in the set, false otherwise
	 */
	public boolean containsRange(Range r);
}
