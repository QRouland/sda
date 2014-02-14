import java.util.*;

public class Fragmenter implements Grinder {
	
	public java.util.Collection<Stone> grind(Stone stone, int diameter)
	{
		ArrayList<Stone> retour = new ArrayList<Stone> ();
		retour.add(stone);
		Stone pierre2 = stone.split();
		while(pierre2.diameter()>diameter || stone.diameter()>diameter) 
		{
			retour.add(stone);
			retour.add(pierre2);
			pierre2 = stone.split();
		}
		retour.add(stone);
		retour.add(pierre2);
		return retour;
	}
}

