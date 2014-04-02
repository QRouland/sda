package src.test;

import src.intset.IntegerSet;
import src.intset.Range;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Reference implementation for the interface IntegerSet.
 * This implementation is based on HashSet&lt;Integer&gt;.
 * @see IntegerSet
 */
public class ReferenceIntegerSet extends HashSet<Integer> implements IntegerSet {

	private static final long serialVersionUID = 1L;

	@Override
	public List<Range> toRanges() {
		List<Range> list = new ArrayList<Range>();
		Integer low = null;
		Integer high = null;
		for(Integer n : this) {
			if (low == null) {
				low = n;
				high = n;
			} else {
				if (n == high + 1) {
					high = n;
				} else {
					list.add(new Range(low,high));
					low = n;
					high = n;
				}
			}
		}
		if (low != null) list.add(new Range(low,high));
		return list;
	}

	@Override
	public boolean addRange(Range r) {
		return addAll(r.elements());
	}

	@Override
	public boolean removeRange(Range r) {
		return removeAll(r.elements());
	}

	@Override
	public boolean retainRange(Range r) {
		return retainAll(r.elements());
	}

	@Override
	public boolean containsRange(Range r) {
		return containsAll(r.elements());
	}

}
