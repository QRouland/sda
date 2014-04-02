package src.intset;


import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Base class for implementing the interface IntegerSet.
 * @see IntegerSet
 */
public abstract class AbstractIntegerSet extends AbstractSet<Integer> implements IntegerSet {
	/**
	 * Internal representation of a sorted list of maximal ranges:
	 * associates the lower bound of each range to its upper bound.
	 */
	protected final NavigableMap<Integer, Integer> ranges;
	protected AbstractIntegerSet() {
		ranges = new TreeMap<Integer,Integer>();
	}
	@Override
	public List<Range> toRanges() {
		ArrayList<Range> list = new ArrayList<Range>();
		for(Map.Entry<Integer, Integer> r : ranges.entrySet()) {
			list.add(new Range(r));
		}
		return list;
	}
	@Override
	public Iterator<Integer> iterator() {
		throw new UnsupportedOperationException();
	}
	@Override
	public int size() {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean addRange(Range r) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean removeRange(Range r) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean retainRange(Range r) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean containsRange(Range r) {
		throw new UnsupportedOperationException();
	}
}
