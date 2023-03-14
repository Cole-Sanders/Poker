import java.util.*;

/** 
 * Represents hand of cards
 * @author Dan Longo
 * @author Suzanne Balik
 * @author Cole Sanders
 */
public class Hand {

    /** Number of cards in a hand */
    public static final int CARDS_IN_HAND = 5;
    
    /** Index of first card in hand */
    public static final int FIRST_CARD = 0;
    
    /** Index of second card in hand */
    public static final int SECOND_CARD = 1;
    
    /** Index of third card in hand */
    public static final int THIRD_CARD = 2;
    
    /** Index of fourth card in hand */
    public static final int FOURTH_CARD = 3;
    
    /** Index of fifth card in hand */
    public static final int FIFTH_CARD = 4;
    
    /** Value of the ten card */
    public static final int TEN = 10;
    
    /** Number of matches for four of a kind */
    public static final int FOUR_OF_A_KIND = 4;
    
    /** Number of matches for three of a kind */
    public static final int THREE_OF_A_KIND = 3;
    
    /** Contains cards in hand */
    private Card[] hand;
    
    /**
     * Constructor initalizing a hand with five cards
     * @param hand an array of five playing cards
     * @throws IllegalArgumentException when hand is null
     * @throws IllegalArgumentException when hand does not contain five elements
     * @throws IllegalArgumentException when an element in hand is null
     */
    public Hand(Card[] hand) {
        if (hand == null) {
            throw new IllegalArgumentException("Null array");
        }
        if (hand.length != CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid array length");
        }
        if (hand[FIRST_CARD] == null || hand[SECOND_CARD] == null || hand[THIRD_CARD] == null ||
                                  hand[FOURTH_CARD] == null || hand[FIFTH_CARD] == null) {
            throw new IllegalArgumentException("Null element");
        }
        this.hand = hand;
    }
    
    /**
     * Gets a card at a given index in the hand
     * @param index position of the card in the hand
     * @return returns the card at the given index
     * @throws IllegalArgumentException when the index is less than zero or more than four
     */
    public Card getCard(int index) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        return hand[index];
    }
    
    /**
     * Replaces a card in the hand with a new given card
     * @param index location of card to be replaced in hand
     * @param card new card going into the hand
     * @throws IllegalArgumentException when the index is less than zero or more than four
     * @throws IllegalArgumentException if card is null
     */
    public void replace(int index, Card card) {
        if (index < 0 || index >= CARDS_IN_HAND) {
            throw new IllegalArgumentException("Invalid index");
        }
        if (card == null) {
            throw new IllegalArgumentException("Null card");
        }
        hand[index] = card;
    }
    
    /**
     * Prints the hand contents to a string
     * @return string listing all the cards in the hand in their order
     */  
    public String toString() {
        String s = "[";
        for (int i = 0; i < CARDS_IN_HAND; ++i) {
            s += hand[i].toString();
            if (i < FIFTH_CARD) {
                s += ", ";
            }
        }
        return s + "]";
    }
    
    /**
     * Compares two hands of cards
     * @param o object of comparison hand
     * @return true if hands are the same false if not
     */ 
    public boolean equals(Object o) {
        if (o instanceof Hand) {
            Hand other = (Hand)o;
            Arrays.sort(other.hand);
            Arrays.sort(hand);
            if (Arrays.equals(hand, other.hand)) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    /**
     * Counts the number of cards with each value in the hand
     * @return tally array containing number of cards of each value from 2 to 14.
     */
    public int[] getCounts() {
        int[] counts = new int[Card.HIGHEST_VALUE + 1];
        for (int i = 0; i < hand.length; i++) {
            counts[hand[i].getValue()]++;
        }
        return counts;
    }

    /**
     * Creates a copy of the hand sorted first by value, then by suit
     * @return copy of the hand sorted first by value, then by suit
     */
    public Card[] getSortedHand() {
        Card[] sortedHand = Arrays.copyOf(hand, hand.length);
        Arrays.sort(sortedHand);
        return sortedHand;
    }
    
    /**
     * Checks if the hand is a flush
     * @return true if it is a flush, false if not
     */
    public boolean isFlush() {
        if (hand[FIRST_CARD].getSuit() == hand[SECOND_CARD].getSuit() && 
            hand[FIRST_CARD].getSuit() == hand[THIRD_CARD].getSuit() && 
            hand[FIRST_CARD].getSuit() == hand[FOURTH_CARD].getSuit()
            && hand[FIRST_CARD].getSuit() == hand[FIFTH_CARD].getSuit()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Checks if the hand is a straight
     * @return true if it is a straight, false if not
     */
    public boolean isStraight() {
        Card[] testHand = getSortedHand();
        if (testHand[FIRST_CARD].getValue() + 1 == testHand[SECOND_CARD].getValue() &&
            testHand[SECOND_CARD].getValue() + 1 == testHand[THIRD_CARD].getValue() &&
            testHand[THIRD_CARD].getValue() + 1 == testHand[FOURTH_CARD].getValue()
            && testHand[FOURTH_CARD].getValue() + 1 == testHand[FIFTH_CARD].getValue()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Checks if the hand is a straigt flush
     * @return true if it is a striaght flush, false if not
     */
    public boolean isStraightFlush() {
        if (isFlush() && isStraight()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Checks if the hand is a royal flush
     * @return true if it is a royal flush, false if not
     */
    public boolean isRoyalFlush() {
        if (isStraightFlush() && getSortedHand()[FIRST_CARD].getValue() == TEN) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Checks if the hand has four of a kind
     * @return true if it has four of a kind, false if not
     */
    public boolean hasFourOfAKind() {
        int[] counts = getCounts();
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] == FOUR_OF_A_KIND) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the hand has three of a kind
     * @return true if it has three of a kind, false if not
     */
    public boolean hasThreeOfAKind() {
        int[] counts = getCounts();
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] == THREE_OF_A_KIND) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the hand has two pairs
     * @return true if it has two pairs, false if not
     */
    public boolean hasTwoPairs() {
        int[] counts = getCounts();
        int pairs = 0;
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] == 2) {
                ++pairs;
            }
        }
        if (pairs == 2) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Checks if the hand has one pair
     * @return true if it has one pair, false if not
     */
    public boolean hasOnePair() {
        int[] counts = getCounts();
        for (int i = 0; i < counts.length; ++i) {
            if (counts[i] == 2) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the hand is a full house
     * @return true if it is a full house, false if not
     */
    public boolean isFullHouse() {
        if (!isStraight()) {
            if (hasThreeOfAKind() && hasOnePair()) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    
}