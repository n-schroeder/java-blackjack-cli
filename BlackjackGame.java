public class BlackjackGame {
    public static void main(String[] args) {
        // Example usage
        Card card1 = new Card(Suit.HEARTS, Rank.ACE);
        Card card2 = new Card(Suit.SPADES, Rank.KING);

        System.out.println(card1); // Output: ACE of HEARTS
        System.out.println("Value: " + card1.getValue()); // Output: Value: 11

        System.out.println(card2); // Output: KING of SPADES
        System.out.println("Value: " + card2.getValue()); // Output: Value: 10
    }
}