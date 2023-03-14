    
/**
 * A class representing a poker card with a value and suit
 * @author Cole Sanders
 *
 */
public class Card implements Comparable<Card> {  
    
    /** A char representing the suit clubs */
    public static final char CLUBS = 'c';
    
    /** A char representing the suit diamonds */
    public static final char DIAMONDS = 'd';
    
    /** A char representing the suit spades */
    public static final char SPADES = 's';
    
    /** A char representing the suit hearts */
    public static final char HEARTS = 'h';
    
    /** Lowest value a card can have */
    public static final int LOWEST_VALUE = 2;
    
    /** Highest value a card can have */
    public static final int HIGHEST_VALUE = 14;
    
    /** Numeric value of card */
    private int value;
    
    /** Suit of card */
    private char suit;
    
    /**
     * Constructor initializing the suit and value of a card
     *
     * @param value numeric value of a card     
     * @param suit character representing the card's suit
     * @throws IllegalArgumentExcepetion when value is less than 
     * two or greater than fourteen
     * @throws IllegalArgumentException when suit is not clubs, 
     * diamonds, spades, and hearts
     */
    public Card(int value, char suit) {
        if (value > HIGHEST_VALUE || value < LOWEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }
        if (suit != CLUBS && suit != DIAMONDS && suit != SPADES && suit != HEARTS) {
            throw new IllegalArgumentException("Invalid suit");
        }
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * This method fetches the value of a card
     * 
     * @return value the numeric value of a card
     */
    public int getValue() {
        return value;
    }
    
    /**
     * This method fetches the suit of a card
     * 
     * @return suit a character representing the card's suit
     */
    public char getSuit() {
        return suit;
    }
    
    /**
     * Tests if two cards are the same
     * 
     * @param o The Card object to which this Card is being compared.
     * @return true if the cards are the same
     *         false if the cards are different
     */
    public boolean equals(Object o) {
        if (o instanceof Card) {
            Card other = (Card)o;
            if(value == other.value && suit == other.suit) {
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
     * This method outputs a cards suit and value to a string in the
     * format "suitvalue"
     * 
     * @return a string containg the suit and value of the card
     */
    public String toString() {
        String s = "";
        s += value;
        return suit + s;
    }
    
    /**
     * This method is used for sorting the cards in a player's hand in a game of
     * Poker. Cards are sorted first by value, then by suit.
     * 
     * @param other
     *            The Card object to which this Card is being compared.
     * @return negative value if this Card should be before the other Card,
     *         positive value if this Card should be after the other Card.
     */
    public int compareTo(Card other) {
        if (this.value != other.value) {
            return this.value - other.value;
        } else {
            return this.suit - other.suit;
        }
    }
}