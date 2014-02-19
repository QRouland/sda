import java.util.*;
public class VraimentSuperOracle implements Oracle {

    /**
     * Mémorise une carte du paquet.
     */
    protected Card myCard;
    private int nbCartes,i;
    private ArrayDeque<Card> myDeque;
	private ArrayList<Card> myList;
	
    @Override
    public void showDeck(Deck d) {
	myDeque = new ArrayDeque<Card>(d.elements());
	nbCartes = d.count();
    }
	
    @Override
    public Card guessFirst() {	
	i=1;
	return myDeque.getFirst();
    }
    
    @Override
    public Card guessNext(Card prev) {
		if(i<=nbCartes){
			myDeque.removeFirstOccurrence(prev);
			myDeque.addLast(prev);
			return myDeque.getFirst();
		}
		return myDeque.pop();
    }
}

