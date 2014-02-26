
public class Ex3 {
	public static void main(String[] args) {

		try {
			Expression test = Builder.fromString("(1+x)/(1+(6*3))");
			System.out.print(test.toString());
		} catch (ParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
