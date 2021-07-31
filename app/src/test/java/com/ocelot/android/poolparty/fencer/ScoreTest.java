package com.ocelot.android.poolparty.fencer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScoreTest {

    private Score score;

    @Before
    public void setUp() {
        score = new Score();
    }

    @Test
    public void testDefaultScore() throws Exception {
        int expected = 0;

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testInitialScore() throws Exception {
        int expected = 0;
        int input = 0;
        score.setValue(input);

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testIncreaseScore() throws Exception {
        int expected = 1;

        score.increaseScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testDecreaseScore() throws Exception {
        int expected = 4;

        score.setValue(5);
        score.decreaseScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testDecreaseScore2() throws Exception {
        int expected = 0;

        score.setValue(0);
        score.decreaseScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testResetScore() throws Exception {
        int expected = 0;

        score.resetScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testIsEqualTrue() throws Exception {
        score.setValue(5);
        Score score1 = new Score(5);

        assertTrue(score.isEqual(score1));
    }

    @Test
    public void testIsEqualFalse() throws Exception {
        Score score1 = new Score(1);

        assertFalse(score1.isEqual(score));
    }

    @Test
    public void testAddRedCard() throws Exception {
        assertEquals(CardType.RED, score.addCard(CardType.RED));
    }

    @Test
    public void testAddTwoYellow() throws Exception {
        score.addCard(CardType.YELLOW);
        assertEquals(CardType.RED, score.addCard(CardType.YELLOW));
    }

    @Test
    public void testAddBlackCard() throws Exception {
        assertEquals(CardType.BLACK, score.addCard(CardType.BLACK));
    }

    @Test
    public void testSetYellow() {
        int expectedValue = 1;
        score.setCards(CardType.YELLOW, 1);
        assertEquals(expectedValue, score.getCards().getYellow());
    }

    @Test
    public void testSetYellow1() {
        int expectedValue = 1;
        score.setCards(CardType.YELLOW, 2);
        assertEquals(expectedValue, score.getCards().getYellow());
    }

    @Test
    public void testSetRed() {
        int expectedValue = 3;
        score.setCards(CardType.RED, 3);
        assertEquals(expectedValue, score.getCards().getRed());
    }

    @Test
    public void testSetBlack() {
        int expectedValue = 5;
        score.setCards(CardType.BLACK, 5);
        assertEquals(expectedValue, score.getCards().getBlack());
    }

    @Test
    public void testRemoveYellow() {
        int expectedValue = 0;
        score.setCards(CardType.YELLOW, 1);
        score.removeCard(CardType.YELLOW);
        assertEquals(expectedValue, score.getCards().getYellow());
    }

    @Test
    public void testRemoveRed() {
        int expectedValue = 2;
        score.setCards(CardType.RED, 3);
        score.removeCard(CardType.RED);
        assertEquals(expectedValue, score.getCards().getRed());
    }

    @Test
    public void testRemoveBlack() {
        int expectedValue = 4;
        score.setCards(CardType.BLACK, 5);
        score.removeCard(CardType.BLACK);
        assertEquals(expectedValue, score.getCards().getBlack());
    }

}
