import java.util.*;
public class SuperOracle implements Oracle {

    /**
     * Mémorise une carte du paquet.
     */
    protected Card myCard;
    private ArrayDeque<Card> myDeque;

    @Override
    public void showDeck(Deck d) {
        myDeque = new ArrayDeque<Card>(d.elements());
    }

    @Override
    public Card guessFirst() {
        return myDeque.getFirst();
    }

    @Override
    public Card guessNext(Card prev) {
        myDeque.removeFirstOccurrence(prev);
        myDeque.addLast(prev);
        return myDeque.getFirst();
    }
}
