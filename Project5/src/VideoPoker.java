/**
 * Runs a game of poker where the player bets with a 
 * given amount of points
 *
 * @author Cole Sanders
 */
public class VideoPoker {
    
    /** Seed value for a random game */
    public static final int RANDOM_GAME = -1;
    
    /** Number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;
    
    /** Value of starting points player has */
    public static final int STARTING_POINTS = 100;
    
    /** Number of points a player needs to start a new game */
    public static final int POINTS_FOR_NEW_GAME = 10;
    
    /** Points awarded for royal flush */
    public static final int ROYAL_FLUSH = 100;
    
    /** Points awarded for straight flush */
    public static final int STRAIGHT_FLUSH = 60;
    
    /** Points awarded for four of a kind */
    public static final int FOUR_OF_A_KIND = 50;
    
    /** Points awarded for a full house */
    public static final int FULL_HOUSE = 40;
    
    /** Points awarded for a flush */
    public static final int FLUSH = 30;
    
    /** Points awarded for a straight */
    public static final int STRAIGHT = 25;
    
    /** Points awarded for three of a kind */
    public static final int THREE_OF_A_KIND = 15;
    
    /** Points awarded for two pairs */
    public static final int TWO_PAIRS = 10;
    
    /** Points awarded for one pair */
    public static final int ONE_PAIR = 7;
    
    /** Contains deck of poker cards */
    private Deck deck;
    
    /** Contains players hand of cards */
    private Hand hand;
    
    /** Contains players points */
    private int points;
    
    /**
     * Constructor initalizing a deck with cards and player points
     * at 100
     * @param seed int for randomizing shuffles
     */
    public VideoPoker(int seed) {
        deck = new Deck(seed);
        points = STARTING_POINTS;
    }
    
    /**
     * Gets the amount of player points
     * @return number of points
     */  
    public int getPoints() {
        return points;
    }
    
    /**
     * Gets the string containing the file path to a card at a given index
     * @param index index of card in the hand
     * @return file path to a card
     */  
    public String getCardFileName(int index) {
        return "cards/" + hand.getCard(index).toString() + ".gif";
    }
    
    /**
     * Gets a card at a given index
     * @param index index of card in the hand
     * @return the card at that index
     */
    public Card getCard(int index) {
        return hand.getCard(index);
    }
    
    /**
     * Sets up a new game by shuffling the deck,
     * subtracting player points by ten, and 
     * filling the hand with new cards
     */  
    public void newGame() {
        points -= POINTS_FOR_NEW_GAME;
        deck.shuffle();
        Card[] cardsInHand = new Card[CARDS_IN_HAND];
        for (int i = 0; i < CARDS_IN_HAND; ++i) {
            cardsInHand[i] = deck.nextCard();
        }
        hand = new Hand(cardsInHand);
    }
    
    /**
     * Replaces a card in the hand
     * @param index of the card in the hand
     */  
    public void replaceCard(int index) {
        hand.replace(index, deck.nextCard());
    }
    
    /**
     * Finds the hand results and outputs them to a string.
     * Also rewards the player with the appropriate amount 
     * of points
     * @return string containing hand's results
     */  
    public String scoreHand() {
        String s = "";
        if (hand.isRoyalFlush()){
            s = "Royal Flush";
            points += ROYAL_FLUSH;
        }
        else if (hand.isStraightFlush()) {
            s = "Straight Flush";
            points += STRAIGHT_FLUSH;
        }
        else if (hand.hasFourOfAKind()) {
            s = "Four of a Kind";
            points += FOUR_OF_A_KIND;
        }
        else if (hand.isFullHouse()) {
            s = "Full House";
            points += FULL_HOUSE;
        }
        else if (hand.isFlush()) {
            s = "Flush";
            points += FLUSH;
        }
        else if (hand.isStraight()) {
            s = "Straight";
            points += STRAIGHT;
        }
        else if (hand.hasThreeOfAKind()) {
            s = "Three of a Kind";
            points += THREE_OF_A_KIND;
        }
        else if (hand.hasTwoPairs()) {
            s = "Two Pairs";
            points += TWO_PAIRS;
        }
        else if (hand.hasOnePair()) {
            s = "One Pair";
            points += ONE_PAIR;
        }
        else {
            s = "No Pair";
        }
        return s;
    }
}