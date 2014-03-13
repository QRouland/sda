import java.util.*;

public class Polish {
	public static int evaluate(List<Symbol> liste, Map<Character,Integer> values) throws UnknownVariableException{
		Stack<Integer> pile = new Stack<Integer>();
		while(!liste.isEmpty()){
			if(liste.get(0).getClass().equals(Constant.class))
					pile.push(Integer.valueOf(liste.get(0).toString()));

			if(liste.get(0).getClass().equals(Variable.class))
					pile.push(values.get((liste.get(0))))f ;

			if(liste.get(0).getClass().equals(Operator.class)){
					Integer droite = pile.pop();
					Integer gauche = pile.pop();
					switch(liste.get(0).toString()){
						case "+" :
							pile.push(droite+gauche);
							break;
						case "-" :
							pile.push(gauche-droite);
							break;
						case "*" :
							pile.push(gauche*droite);
							break;
						case "/" :
							pile.push(gauche/droite);
					}
			}
			liste.remove(0);
		}
		return pile.pop();
	}
}
