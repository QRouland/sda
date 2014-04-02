package src.intset;

import java.util.Collection;
import java.util.Map;


public class RTIntegerSet extends AbstractIntegerSet implements IntegerSet{


	@Override
	public boolean add(Integer e) {
		
		boolean havetoremove =false;
		int updateinf = -1;
		
		if(ranges.isEmpty()){
			ranges.put(e, e);
			return true;
		}
		
		if(contains(e)) return false; // deja dedans
		
		for(Map.Entry<Integer, Integer> entry : ranges.entrySet()){
			int inf = entry.getKey();
			int sup = entry.getValue();
			
			if(havetoremove){
				ranges.remove(inf);
				ranges.put(updateinf,sup);
				return true;
			}

			if(e==inf-1){
				ranges.remove(inf);
				ranges.put(e,sup);
				return true;
			}
			
			if(e==sup+1) {
				ranges.put(inf,e);
				if(ranges.get(e+1) != null){
					havetoremove=true;
					updateinf=inf;	
				}
				else return true;
			}
			
			if(e<inf-1 || e>sup+1 && inf == ranges.lastKey()){
				ranges.put(e, e);
				return true;
			}
			
			
		}
		
		return false;
	}
/*
	public boolean contains(Integer i){
		if(i<ranges.firstKey()||i>ranges.lastKey()) return false;
		for(Map.Entry<Integer, Integer> entry : ranges.entrySet()){
			int inf = entry.getKey();
			int sup = entry.getValue();
			
			if(i<inf)return false; // evite de boucler inutilement
			
			if(i<=sup && i>=inf) return true; // si compris dans l'interval
		}
		return false;
	}
*/

	public boolean contains(Integer i){ // dichotomie
		Integer temp = ranges.floorKey(i);
		if(temp!=null)
			if(i==temp || i>temp && i<ranges.get(temp)) return true;
		return false;
	}
	
	
	@Override
	public void clear() {
		ranges.clear();
	}

	@Override
	public boolean isEmpty() {
		return ranges.isEmpty();
	}

	@Override
	public int size() {
		if(ranges.isEmpty()) return 0;
		return ranges.get(ranges.lastKey())-ranges.firstKey();
	}
	
	
}
