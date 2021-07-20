package com.ocelot.android.poolparty.fencer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FencerTest {
    private Fencer fencer;

    @Before
    public void setUp() {
        FencerID fencerID = new FencerID();
        fencer = new Fencer(fencerID, 2);
    }

    // Will only work without testIndexCounter()
//    @Test
//    public void testDefaultIndex() {
//        int expectedIndex = 0;
//
//        assertEquals(expectedIndex, fencer.getIndex());
//    }

    @Test
    public void testIndexCounter() {
        int expectedIndex1 = 0;
        int expectedIndex2 = 1;

        FencerID fencerID2 = new FencerID("A", "H", Hand.LEFT);
        Fencer fencer2 = new Fencer(fencerID2);
        assertEquals(expectedIndex1, fencer.getIndex());
        assertEquals(expectedIndex2, fencer2.getIndex());
    }

    @Test
    public void testDefaultFencerID() {
        String expectedFirstName = "First";
        String expectedLastName = "Last";
        Hand expectedHand = Hand.RIGHT;

        assertEquals(expectedFirstName, fencer.getFirstName());
        assertEquals(expectedLastName, fencer.getLastName());
        assertEquals(expectedHand, fencer.getHand());
    }

    @Test
    public void testFencerID() {
        String expectedFirstName = "Jonathan";
        String expectedLastName = "Candles";
        Hand expectedHand = Hand.LEFT;

        fencer.setFirstName("Jonathan");
        fencer.setLastName("Candles");
        fencer.setHand(Hand.LEFT);

        assertEquals(expectedFirstName, fencer.getFirstName());
        assertEquals(expectedLastName, fencer.getLastName());
        assertEquals(expectedHand, fencer.getHand());
    }

    @Test
    public void testEmptyCompSpecs1() {
        assertNull(fencer.getRating());
        assertNull(fencer.getClub());
    }

    @Test
    public void testEmptyCompSpecs2() {
        Rating expectedRating = Rating.U;
        String expectedClub = "Unattached";

        assertEquals(expectedRating, fencer.getCompSpecs().getRating());
        assertEquals(expectedClub, fencer.getCompSpecs().getClub());
    }

    @Test
    public void testRating() {
        Rating expectedRating = Rating.A;
        fencer.setRating(Rating.A);
        assertEquals(expectedRating, fencer.getRating());
    }

    @Test
    public void testClub() {
        String expectedClub = "King of the Iron Fist";
        fencer.setClub("King of the Iron Fist");
        assertEquals(expectedClub, fencer.getClub());
    }

    @Test
    public void testScores() {
        int expectedScore = 0;
        for (int i=0; i<fencer.getScores().length; i++) {
            assertEquals(expectedScore, fencer.getScores()[i].getValue());
        }
    }

    @Test
    public void testScore() {
        int expectedScore = 5;
        fencer.setScore(1, 5);
        assertEquals(expectedScore, fencer.getScore(1));
        assertEquals(0, fencer.getScore(0));
    }

    @Test
    public void testIncreaseScore() {
        int expectedScore = 1;
        fencer.increaseScore(1);
        assertEquals(expectedScore, fencer.getScore(1));
    }

    @Test
    public void testDecreaseScore1() {
        int expectedScore = 0;
        fencer.decreaseScore(1);
        assertEquals(expectedScore, fencer.getScore(1));
    }

    @Test
    public void testDecreaseScore2() {
        int expectedScore = 4;
        for (int i=0; i<5; i++) {
            fencer.increaseScore(1);
        }
        fencer.decreaseScore(1);
        assertEquals(expectedScore, fencer.getScore(1));
    }

    @Test
    public void testGetCards1() {
       Cards expectedCards = new Cards();

       assertTrue(expectedCards.isEqual(fencer.getCards(1)));
    }

    @Test
    public void testGetCards2() {
        Cards expectedCards = new Cards();
        expectedCards.addYellow();
        expectedCards.addBlack();
        expectedCards.addRed();
        expectedCards.addRed();

        assertEquals(CardType.YELLOW, fencer.addCard(1, CardType.YELLOW));
        assertEquals(CardType.RED, fencer.addCard(1, CardType.RED));
        assertEquals(CardType.RED, fencer.addCard(1, CardType.YELLOW));
        assertEquals(CardType.BLACK, fencer.addCard(1, CardType.BLACK));

        assertTrue(expectedCards.isEqual(fencer.getCards(1)));

    }

    @Test
    public void testDecreaseCard() {

    }

}
