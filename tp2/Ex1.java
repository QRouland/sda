import java.util.*;

public class Ex1
{
	public static void main (String[] args)
	{
		Deck myDeck = new Deck(8);
		System.out.println(myDeck.count());
		System.out.println(myDeck.elements().toString());
		myDeck.shuffle();
		System.out.println();
		System.out.println(myDeck.elements().toString());
		ArrayList<Card> myList = new ArrayList<Card>(myDeck.elements());
		System.out.println();
		System.out.println(myList.toString());
		Collections.sort(myList);
		System.out.println();
		System.out.println(myList.toString());
	}
}

