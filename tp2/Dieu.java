import java.util.*;
public class Dieu implements Oracle {

    protected Deck deckHacked;

    @Override
    public void showDeck(Deck d) {
        deckHacked = d;
    }

    @Override
    public Card guessFirst() {
        try{deckHacked = (Deck)deckHacked.clone();}catch (Exception e) {}
        deckHacked.
        return deckHacked.iterator().next();
    }

    @Override
    public Card guessNext(Card prev) {
        return deckHacked.iterator().next();
    }
}

