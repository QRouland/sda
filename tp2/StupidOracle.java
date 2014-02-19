
/**
 * Implémentation minimaliste de l'interface Grinder.
 * @see Grinder
 */
 
 //
 
public class StupidOracle implements Oracle {

    /**
     * Mémorise une carte du paquet.
     */
    protected Card myCard;
	
    @Override
    public void showDeck(Deck d) {
	myCard = d.takeOnTop();
	// On mémorise la carte du dessus du paquet
    }
	
    @Override
    public Card guessFirst() {
	return myCard;
    }
    
    @Override
    public Card guessNext(Card prev) {
	return myCard;
    }
}
