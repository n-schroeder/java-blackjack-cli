import java.util.ArrayList;

public class Hand {
    
    // property to hold the cards in the hand
    private ArrayList<Card> cardsInHand;

    // constructor
    public Hand() {
        // initialize the cardsInHand list
        this.cardsInHand = new ArrayList<>();
    }

    // method to add a card to the hand
    public void addCard(Card card) {
        this.cardsInHand.add(card);
    }

    // method to calculate the total value of the hand
    public int calculateValue() {
        int totalValue = 0;
        int aceCount = 0;
        
        // loop 1: add up all cards & count aces
        for (Card card : this.cardsInHand) {
            // increment total hand value
            totalValue += card.getValue();
            // count aces
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }

        }

        // loop 2: adjust for bust
        while (totalValue > 21 && aceCount > 0) {
            // remove 10 from ace 
            totalValue -= 10;
            // decrement ace count
            aceCount--;
        }

        return totalValue;
    }

    // create toString method to display hand aesthetically
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Hand: [");

        for (int i = 0; i < this.cardsInHand.size(); i++) {
            output.append(this.cardsInHand.get(i).toString());
            if (i < this.cardsInHand.size() - 1) {
                output.append(", ");
            }
        }

        output.append("] Value: ").append(this.calculateValue());
        return output.toString();
    }
}