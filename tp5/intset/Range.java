package src.intset;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A class representing integer ranges by their lower and upper bound.
 */
public class Range {
	/**
	 * Lower bound of the range.
	 */
	public final int lower;
	/**
	 * Upper bound of the range.
	 */
	public final int upper;
	/**
	 * Constructs a range from its lower bound and upper bound.
	 * @param lower The lower bound
	 * @param upper The upper bound
	 */
	public Range(int lower, int upper) {
		this.lower = lower;
		this.upper = upper;
	}
	/**
	 * Constructs a range from a map entry.
	 * The key is used as lower bound and the value as upper bound.
	 * @param entry A map entry
	 */
	public Range(Map.Entry<Integer, Integer> entry) {
		this.lower = entry.getKey();
		this.upper = entry.getValue();
	}
	/**
	 * Builds the list of all integer in the range, in increasing order.
	 * Time and space complexity is in the size of the range.
	 * @return The list of all integer in the range
	 */
	public List<Integer> elements() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int n = lower; n <= upper; n++) {
			l.add(n);
		}
		return l;
	}
	/**
	 * Checks whether an element belong to the range.
	 * Constant time complexity.
	 * @param x The element to search
	 * @return true if x belongs to the range, false otherwise
	 */
	public boolean contains(int x) {
		return lower <= x && x <= upper;
	}
	/**
	 * Compact representation of the range.
	 */
	@Override
	public String toString() {
		if (lower == upper) return ""+lower;
		else return lower+".."+upper;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + upper;
		result = prime * result + lower;
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
		Range other = (Range) obj;
		if (upper != other.upper)
			return false;
		if (lower != other.lower)
			return false;
		return true;
	}
}
