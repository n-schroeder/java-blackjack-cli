import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        // play again while loop
        boolean playAgain = true;
        Scanner scnr = new Scanner(System.in);

        while (playAgain == true) {
            // game logic
            Deck deck = new Deck();
            deck.shuffle();
            Hand playerHand = new Hand();
            Hand dealerHand = new Hand();
            
            // initial deal
            playerHand.addCard(deck.dealCard());
            // handle upcard
            Card upCard = deck.dealCard();
            dealerHand.addCard(upCard);
            playerHand.addCard(deck.dealCard());
            dealerHand.addCard(deck.dealCard());

            // show hands
            System.out.println("Dealer: [" + upCard + "] Value: " + upCard.getValue());
            System.out.println(playerHand);

            // check for player blackjack
            if (playerHand.calculateValue() == 21) {
                if (dealerHand.calculateValue() == 21) {
                    System.out.println("Both you and the dealer have blackjack! It's a push.");
                    System.exit(0);
                }
                else {
                    System.out.println("Blackjack! You win!");
                    System.exit(0);
                }
            }

            // store sneaky dealer blackjack
            boolean dealerBlackjack = false;
            if (dealerHand.calculateValue() == 21) {
                dealerBlackjack = true;
            }
            // prompt player (hit or stand)
            boolean playerTurn = true;
            while (playerTurn == true) {
                System.out.println("Would you like to (h)it or (s)tand?");
                System.out.print(">>> ");
                String playerChoice = scnr.nextLine();
                if (playerChoice.equalsIgnoreCase("h")) {
                    //hit
                    playerHand.addCard(deck.dealCard());
                    System.out.println("Dealer: [" + upCard + "] Value: " + upCard.getValue());
                    System.out.println(playerHand);
                    // check for bust
                    if (playerHand.calculateValue() > 21) {
                        System.out.println("Bust! You lose.");
                        System.exit(0);
                    }
                    else if (playerHand.calculateValue() == 21) {
                        // end player turn
                        playerTurn = false;
                        System.out.println("21! You stand.");
                    }
                }

                else if (playerChoice.equalsIgnoreCase("s")) {
                    //stand
                    playerTurn = false;
                }
                else {
                    System.out.println("Invalid choice, please enter 'h' or 's'.");
                }
            }

            // dealer turn
            if (playerTurn == false) {
                System.out.println("Dealer's turn...");
                System.out.println(dealerHand);

                // check for dealer blackjack
                if (dealerBlackjack == true) {
                    System.out.println("Dealer has blackjack! You lose.");
                    System.exit(0);
                }

                // dealer hit until 17+
                while (dealerHand.calculateValue() < 17) {
                    dealerHand.addCard(deck.dealCard());
                    System.out.println("Dealer hits...");
                    System.out.println(dealerHand);
                    }
                }
                // determine winner
                int playerTotal = playerHand.calculateValue();
                int dealerTotal = dealerHand.calculateValue();
                if (dealerTotal > 21) {
                    System.out.println("Dealer busts! You win!");
                }
                else if (dealerTotal > playerTotal) {
                    System.out.println("Dealer wins with " + dealerTotal + " against your " + playerTotal + ".");
                }
                else if (dealerTotal < playerTotal) {
                    System.out.println("You win with " + playerTotal + " against dealer's " + dealerTotal + "!");
                }
                else {
                    System.out.println("It's a push at " + playerTotal + "and" + dealerTotal + "!");
                }
            }

            // prompt to play again
            System.out.println("Would you like to play again? (y/n)");
            System.out.print(">>> ");
            String againChoice = scnr.nextLine();
            if (againChoice.equalsIgnoreCase("y")) {
                playAgain = true;
            }
            else {
                playAgain = false;
            }
        }


       
       
       
       
       
       
       
       
       
        // |TESTING::TESTING::TESTING|
        // Create some cards and display their values
        /*
        Card card1 = new Card(Suit.HEARTS, Rank.ACE);
        Card card2 = new Card(Suit.SPADES, Rank.KING);

        System.out.println(card1); // Output: ACE of HEARTS
        System.out.println("Value: " + card1.getValue()); // Output: Value: 11

        System.out.println(card2); // Output: KING of SPADES
        System.out.println("Value: " + card2.getValue()); // Output: Value: 10
        */

        // Create and shuffle a deck, then deal a card
        /*
        Deck deck = new Deck();
        deck.shuffle();
        Card dealtCard = deck.dealCard();
        System.out.println("Dealt Card: " + dealtCard);
        System.out.println("Cards Left: " + deck.cardsLeft());
        
        // iteration 2
        dealtCard = deck.dealCard();
        System.out.println("Dealt Card: " + dealtCard);
        System.out.println("Cards Left: " + deck.cardsLeft());
        
        // shuffle
        deck.shuffle();

        // iteration 3
        dealtCard = deck.dealCard();
        System.out.println("Dealt Card: " + dealtCard);
        System.out.println("Cards Left: " + deck.cardsLeft());
        */

        /*// create a hand, add cards, and display hand
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        hand.addCard(new Card(Suit.SPADES, Rank.KING));
        System.out.println(hand);
        */
    }
