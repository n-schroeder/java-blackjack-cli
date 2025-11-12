public class Card {
    private final Suit suit;
    private final Rank rank;

    // constructor
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // getters
    public Suit getSuit() {
        return this.suit;
    }

    public Rank getRank() {
        return this.rank;
    }

    public int getValue() {
        return this.rank.getValue();
    }

    // formatting
    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }
}