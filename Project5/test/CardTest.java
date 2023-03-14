import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Card class
 * @author Suzanne Balik
 * @author Cole Sanders
 */
public class CardTest {

    /** card two of hearts for testing */
    private Card twoOfHearts;
    
    /** card seve of spades for testing */
    private Card sevenOfSpades;

    /**
     * Create cards for testing
     */
    @BeforeEach
    public void setUp() {
        twoOfHearts = new Card(2, 'h');
        sevenOfSpades = new Card(7, 's');
    }

    /**
     * Tests that constants are correct
     */
    @Test
    public void testConstants() {
        // The following tests test that constants are defined as specified
        assertEquals('c', Card.CLUBS, "CLUBS");
        assertEquals('d', Card.DIAMONDS, "DIAMONDS");
        assertEquals('s', Card.SPADES, "SPADES");
        assertEquals('h', Card.HEARTS, "HEARTS");
        assertEquals(2, Card.LOWEST_VALUE, "LOWEST_VALUE");
        assertEquals(14, Card.HIGHEST_VALUE, "HIGHEST_VALUE");
    }

    /**
     * Tests getValue with two of hearts
     */
    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals(2, twoOfHearts.getValue(), "twoOfHearts value");
    }
    
    /**
     * Tests getValue with seven of spades
     */
    @Test
    public void testGetValueSevenOfSpades() {
        assertEquals(7, sevenOfSpades.getValue(), "sevenOfSpades value");
    }

    /**
     * Tests getSuit with two of hearts
     */
    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals('h', twoOfHearts.getSuit(), "twoOfHearts suit");
    }
    
    /**
     * Tests getSuit with seven of spades
     */
    @Test
    public void testGetSuitSevenOfSpades() {
        assertEquals('s', sevenOfSpades.getSuit(), "sevenOfSpades suit");
    }

    /**
     * Tests toString with two of hearts
     */
    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("h2", twoOfHearts.toString(), "twoOfHearts toString");
    }
    
    /**
     * Tests toString with seven of spades
     */
    @Test
    public void testToStringSevenOfSpades() {
        assertEquals("s7", sevenOfSpades.toString(), "sevenOfSpades toString");
    }

    /**
     * Tests equals with two of hearts
     */
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue(twoOfHearts.equals(twoOfHearts), "twoOfHearts equals with same instance");
        assertTrue(twoOfHearts.equals(new Card(2, 'h')), 
                   "twoOfHearts equals with different instances");
        assertFalse(twoOfHearts.equals(new Card(4, 'h')), "twoOfHearts with different value");
        assertFalse(twoOfHearts.equals(new Card(2, 's')), "twoOfHearts with different suit");
        assertFalse(twoOfHearts.equals(new Card(5, 'c')), 
                    "twoOfHearts with different value and suit");
        assertFalse(twoOfHearts.equals(null), "twoOfHearts compared to null object");
        assertFalse(twoOfHearts.equals("twoOfHearts"), "twoOfHearts compared to String");
    }
    
    /**
     * Tests equals with seven of spades
     */
    @Test
    public void testEqualsSevenOfSpades() {
        assertTrue(sevenOfSpades.equals(sevenOfSpades), "sevenOfSpades equals with same instance");
        assertTrue(sevenOfSpades.equals(new Card(7, 's')), 
                   "sevenOfHearts equals with different instances");
        assertFalse(sevenOfSpades.equals(new Card(8, 's')), "sevenOfSpades with different value");
        assertFalse(twoOfHearts.equals(new Card(7, 'h')), "sevenOfSpades with different suit");
        assertFalse(twoOfHearts.equals(new Card(5, 'c')), 
                    "sevenOfSpades with different value and suit");
        assertFalse(twoOfHearts.equals(null), "sevenOfSpades compared to null object");
        assertFalse(twoOfHearts.equals("sevenOfSpades"), "sevenOfSpades compared to String");
    }

    /** 
     * Tests compareTo() method - you do not need to add any additional tests
     */
    @Test
    public void testCompareTo() {
        Card fiveOfDiamonds = new Card(5,'d');
        Card fiveOfHearts = new Card(5,'h');
        Card twoOfSpades = new Card(2,'s');
        Card sevenOfClubs = new Card(7,'c');
        assertEquals(-5, twoOfSpades.compareTo(sevenOfClubs), "compare Spades 2 to Clubs 7");
        assertEquals(3, fiveOfHearts.compareTo(twoOfSpades), "compare Hearts 5 to Spades 2");
        assertEquals(-4, fiveOfDiamonds.compareTo(fiveOfHearts), "compare Diamonds 5 to Hearts 5");
    }

    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        // Testing constructor with low invalid value
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(1, 'h'), "Constructor value 1");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 1 message");
                
        // Testing constructor with high invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(15, 's'), "Constructor value 15");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 15 message");
                
        // Testing constructor with invalid value and invalid suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(0, 'w'), "Constructor value 0 suit w");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 0 suit w message");
                
        // Testing constructor with invalid lowercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(5, 'x'), "Constructor suit x");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit x message");
                
        // Testing constructor with invalid uppercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card(5, 'D'), "Constructor suit D");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit D message");
    }
}