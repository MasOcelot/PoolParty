package com.ocelot.android.poolparty.bout;

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
        cards.addYellow();

        assertEquals(expectedYellow, cards.getYellow());
        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void addRed1() {
        int expectedRed = 1;
        cards.addRed();

        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void addRed2() {
        int expectedYellow = 1;
        int expectedRed = 1;
        cards.addYellow();
        cards.addYellow();

        assertEquals(expectedYellow, cards.getYellow());
        assertEquals(expectedRed, cards.getRed());
    }

    @Test
    public void addBlack() {
        int expectedBlack = 1;
        cards.addBlack();

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
        otherCards.addYellow();
        otherCards.setBlack(-1);

        assertFalse(cards.isEqual(otherCards));

        cards.addYellow();
        cards.addYellow();

        assertTrue(cards.isEqual(otherCards));
    }
}