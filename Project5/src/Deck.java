import java.util.*;

/**
 * A class representing a deck of poker cards
 * @author Cole Sanders
 */
public class Deck {
    
    /** Number of cards in a poker deck */
    public static final int CARDS_IN_DECK = 52;
    
    /** High cutoff for initializng club cards in constructor */
    public static final int CLUBS_HIGH_CUTOFF = 13;
    
    /** High cutoff for initializng diamond cards in constructor */
    public static final int DIAMONDS_HIGH_CUTOFF = 26;
    
    /** Low cutoff for initializng diamond cards in constructor */
    public static final int DIAMONDS_LOW_CUTOFF = 13;
    
    /** High cutoff for initializng heart cards in constructor */
    public static final int HEARTS_HIGH_CUTOFF = 39;
    
    /** Low cutoff for initializng heart cards in constructor */
    public static final int HEARTS_LOW_CUTOFF = 26;
    
    /** High cutoff for initializng spade cards in constructor */
    public static final int SPADES_HIGH_CUTOFF = 52;
    
    /** Low cutoff for initializng spade cards in constructor */
    public static final int SPADES_LOW_CUTOFF = 39;
    
    /**
     * An array containing individual cards
     */
    private Card[] cards;
    
    /**
     * An integer holding the index of the next card
     */    
    private int next = 0;
    
    /**
     * A seed for randomizing deck shuffles
     */    
    private int seed;
    
    /**
     * Constructor initalizing a deck with all the playing cards
     * and a given seed
     * @param seed int for randomizing shuffles
     */
    public Deck(int seed) {
        cards = new Card[CARDS_IN_DECK];
        for (int i = 0; i < CARDS_IN_DECK; ++i) {
            if (i < CLUBS_HIGH_CUTOFF) {
                cards[i] = new Card(Card.LOWEST_VALUE + i, Card.CLUBS);
            }
            else if (i < DIAMONDS_HIGH_CUTOFF) {
                cards[i] = new Card(Card.LOWEST_VALUE + i - DIAMONDS_LOW_CUTOFF, Card.DIAMONDS);
            }
            else if (i < HEARTS_HIGH_CUTOFF) {
                cards[i] = new Card(Card.LOWEST_VALUE + i - HEARTS_LOW_CUTOFF, Card.HEARTS);
            }
            else if (i < SPADES_HIGH_CUTOFF) {
                cards[i] = new Card(Card.LOWEST_VALUE + i - SPADES_LOW_CUTOFF, Card.SPADES);
            }
        }
        this.seed = seed;
    }

    /**
     * Shuffles the deck randomly or according to a given seed
     */    
    public void shuffle() {
        Random rand;
        if (seed != -1) {
            rand = new Random(seed);
        }
        else {
            rand = new Random();
        }
        Card placeHolder = new Card(2, 'c');
        for (int i = CARDS_IN_DECK - 1; i > 0; --i) {
            int randomInt = rand.nextInt(i + 1);
            placeHolder = cards[i];
            cards[i] = cards[randomInt];
            cards[randomInt] = placeHolder;
        }
        next = 0;
    }
    
    /**
     * Retrieves the next card in the deck and increments pointer
     * @return the next card in the deck
     * @throws IllegalStateException if pointer is past the last card
     */ 
    public Card nextCard() {
        if (next >= CARDS_IN_DECK) {
            throw new IllegalStateException("No more cards");
        }
        int cardLocation = next;
        ++next;
        return cards[cardLocation];
    }
    
    /**
     * Compares two decks of cards
     * @param o object of comparison deck
     * @return true if decks are the same false if not
     */ 
    public boolean equals(Object o) {
        if (o instanceof Deck) {
            Deck other = (Deck)o;
            if(Arrays.equals(cards, other.cards) && next == other.next && seed == other.seed) {
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
     * Prints the deck contents to a string
     * @return string listing all the cards in the deck in their order
     */     
    public String toString() {
        String s = "";
        for (int i = 0; i < CARDS_IN_DECK; ++i) {
            s += "card " + i + ": " + cards[i].toString() + "\n";
        }
        return s;
    }
}