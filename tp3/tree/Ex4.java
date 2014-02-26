import java.util.*;


public class Ex4 {

	public static void main(String[] args) {
		String lol = "(2*x) + (6*y) - (y/2)";
		TreeMap<Character,Integer> temp = new TreeMap<Character,Integer>();
		temp.put('x', 1);
		temp.put('y', 2);
		System.out.print(temp);
		
		try {
			Expression test = Builder.fromString(lol);
			test.evaluate(temp);
			System.out.print(test);
		} catch (Exception e) {}
		

	}

}
