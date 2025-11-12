import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    
    // this property will hold all 52 cards
    private ArrayList<Card> cards;

    // constructor
    public Deck() {
        // initialize the cards list
        this.cards = new ArrayList<>();

        // for-each loop to populate ArrayList with 52 cards
        // loop through suits...
        for (Suit suit : Suit.values()) {
            // ...and ranks...
            for (Rank rank : Rank.values()) {
                // ...then create a new card & add it to the list
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    // method to shuffle the deck
    public void shuffle() {
        // built-in method to shuffle any ArrayList
        Collections.shuffle(this.cards);
    }

    // deal top card from deck
    public Card dealCard() {
        // remove object at index 0,
        // then return that same object
        return this.cards.remove(0);
    }

    // helper method to get number of remaining cards
    public int cardsLeft() {
        return this.cards.size();
    }
}