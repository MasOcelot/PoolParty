package com.ocelot.android.poolparty.fencer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardsTest {
    Cards cards = null;

    @Before
    public void setUp() throws Exception {
        cards = new Cards();
    }

    @Test
    public void addYellow() {
        int expectedYellow = 1;
        int expectedRed = 0;
        assertEquals(CardType.YELLOW, cards.addYellow());

        assertEquals(expectedYellow, cards.getYellow());
        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void addRed1() {
        int expectedRed = 1;
        assertEquals(CardType.RED, cards.addRed());

        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void addRed2() {
        int expectedYellow = 1;
        int expectedRed = 1;
        cards.addYellow();
        assertEquals(CardType.RED, cards.addYellow());

        assertEquals(expectedYellow, cards.getYellow());
        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void addBlack() {
        int expectedBlack = 1;
        assertEquals(CardType.BLACK, cards.addBlack());

        assertEquals(expectedBlack, cards.getBlack());
    }

    @Test
    public void getYellow() {
        int expectedYellow = 1;
        cards.addYellow();

        assertEquals(expectedYellow, cards.getYellow());
    }

    @Test
    public void getRed() {
        int expectedRed = 1;
        cards.addRed();

        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void getBlack() {
        int expectedBlack = 0;

        assertEquals(expectedBlack, cards.getBlack());
    }

    @Test
    public void setYellow() {
        int expectedYellow = 1;
        cards.setYellow(1);

        assertEquals(expectedYellow, cards.getYellow());

        expectedYellow = 0;
        cards.setYellow(-100);
        assertEquals(expectedYellow, cards.getYellow());

        expectedYellow = 1;
        cards.setYellow(999);

        assertEquals(expectedYellow, cards.getYellow());
    }

    @Test
    public void setRed() {
        int expectedRed = 1;

        cards.setRed(1);
        assertEquals(expectedRed, cards.getRed());

        expectedRed = 2;
        cards.setRed(2);
        assertEquals(expectedRed, cards.getRed());

        expectedRed = 0;
        cards.setRed(-5);
        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void setBlack() {
        int expectedBlack = 1;

        cards.setBlack(1);
        assertEquals(expectedBlack, cards.getBlack());

        expectedBlack = 2;
        cards.setBlack(2);
        assertEquals(expectedBlack, cards.getBlack());

        expectedBlack = 0;
        cards.setBlack(-7);
        assertEquals(expectedBlack, cards.getBlack());
    }

    @Test
    public void isEqual() {
        Cards otherCards = new Cards();

        assertTrue(cards.isEqual(otherCards));

        otherCards.addRed();
        otherCards.addRed();
        otherCards.addYellow();
        otherCards.setBlack(-1);

        assertFalse(cards.isEqual(otherCards));

        cards.addYellow();
        cards.addYellow();
        cards.addYellow();

        System.out.println(cards.toString());

        assertTrue(cards.isEqual(otherCards));
    }

    @Test
    public void removeBlack() {
        int expectedValue = 1;
        cards.setBlack(2);
        cards.removeBlack();
        assertEquals(expectedValue, cards.getBlack());
    }

    @Test
    public void removeRed() {
        int expectedValue = 0;
        cards.setRed(1);
        cards.removeRed();
        assertEquals(expectedValue, cards.getRed());
    }

    @Test
    public void removeYellow() {
        int expectedValue = 0;
        cards.setYellow(1);
        cards.removeYellow();
        assertEquals(expectedValue, cards.getYellow());
    }
}