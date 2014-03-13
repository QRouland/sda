import java.util.Map;
import java.util.TreeMap;

public class ExerciceB {

	public static void main(String[] args) {
		String lol = "(x-1)*4";
		Map<Character,Integer> temp = new TreeMap<Character,Integer>();
		try {
			temp.put('x', 1);
			System.out.println(temp);
			
			Expression test = Builder.fromString(lol);
			
			System.out.println(test);
			System.out.println(test.rpn());
			System.out.println("resultat : " + Polish.evaluate(test.rpn(),temp));
		} catch (Exception e) { e.printStackTrace(); }
	}
}



