import java.util.*;
public class VraimentSuperOracle implements Oracle {

    /**
     * Mémorise une carte du paquet.
     */
    protected Card myCard;
    private ArrayDeque<Card> myDeque;
    private LinkedHashSet<Card> myList;

    @Override
    public void showDeck(Deck d) {
        myDeque = new ArrayDeque<Card>();
        myList = new LinkedHashSet<Card>(d.elements());
    }

    @Override
    public Card guessFirst() {
        return myList.iterator().next();
    }

    @Override
    public Card guessNext(Card prev) {
        myDeque.add(prev);
        if(!myList.isEmpty()) myList.remove(prev);
        if(!myList.isEmpty()) return myList.iterator().next();
        return myDeque.pop();
    }
}

