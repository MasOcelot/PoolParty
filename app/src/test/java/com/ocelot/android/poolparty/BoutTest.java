package com.ocelot.android.poolparty;

import com.ocelot.android.poolparty.bout.Bout;
import com.ocelot.android.poolparty.bout.Side;
import com.ocelot.android.poolparty.fencer.CardType;
import com.ocelot.android.poolparty.fencer.Fencer;
import com.ocelot.android.poolparty.fencer.FencerID;
import com.ocelot.android.poolparty.fencer.Hand;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoutTest {
    FencerID id1;
    FencerID id2;
    Fencer fencer1;
    Fencer fencer2;
    Bout bout;
    int rightIndex = 3;
    int leftIndex = 5;

    @Before
    public void setUp() {
        id1 = new FencerID("Mark", "Hamill", Hand.RIGHT);
        id2 = new FencerID("Harrison", "Ford", Hand.RIGHT);
        fencer1 = new Fencer(id1, 6);
        fencer1.setIndex(rightIndex);
        fencer2 = new Fencer(id2, 6);
        fencer2.setIndex(leftIndex);
        try {
            bout = new Bout(fencer1, fencer2, fencer1.getIndex(), fencer2.getIndex());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void testNames() {
        String expectedLeftName = "Ford";
        String expectedRightName = "Hamill";

        assertEquals(expectedLeftName, bout.getLeftFencer().getLastName());
        assertEquals(expectedRightName, bout.getRightFencer().getLastName());
    }

    @Test
    public void testIndices() {
        int expectedLeftIndex = 5;
        int expectedRightIndex = 3;

        assertEquals(expectedLeftIndex, bout.getLeftIndex());
        assertEquals(expectedRightIndex, bout.getRightIndex());
    }

    @Test
    public void testScoreNegative0() {
        int expectedScore = 0;

        bout.decreaseLeft();
        assertEquals(expectedScore, bout.getScore(Side.LEFT));
    }

    @Test
    public void testScoreNegative1() {
        int expectedScore = 4;
        int i = 5;
        while (i > 0) {
            bout.increaseLeft();
            i--;
        }
        bout.decreaseLeft();
        assertEquals(expectedScore, bout.getScore(Side.LEFT));
    }

    @Test
    public void testScorePositive() {
        int expectedScore = 1;

        bout.increaseScore(Side.LEFT);
        assertEquals(expectedScore, bout.getScore(Side.LEFT));
    }

    @Test
    public void testScoreRedCard0() {
        int expectedRightScore = 2;
        int expectedLeftScore = 0;
        int expectedLeftRed = 1;

        bout.increaseRight();
        bout.addCard(Side.LEFT, CardType.RED);

        assertEquals(expectedLeftScore, bout.getScore(Side.LEFT));
        assertEquals(expectedRightScore, bout.getScore(Side.RIGHT));
        assertEquals(expectedLeftRed, bout.getCardCount(Side.LEFT, CardType.RED));
    }

    @Test
    public void testScoreDoubleYellow() {
        int expectedRightScore = 0;
        int expectedRightYellow = 1;
        int expectedLeftScore = 1;

        bout.addCard(Side.RIGHT, CardType.YELLOW);
        bout.addCard(Side.RIGHT, CardType.YELLOW);

        assertEquals(expectedLeftScore, bout.getScore(Side.LEFT));
        assertEquals(expectedRightScore, bout.getScore(Side.RIGHT));
        assertEquals(expectedRightYellow, bout.getCardCount(Side.RIGHT, CardType.YELLOW));
    }

}
