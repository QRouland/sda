
public class ExerciceA {

	public static void main(String[] args) {
		String lol = "(x-1)*4";
		try {
			Expression test = Builder.fromString(lol);
			System.out.println(test);
			System.out.println("resultat : " + test.rpn());
		} catch (Exception e) { e.printStackTrace(); }
	}
}


