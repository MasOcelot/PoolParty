package com.ocelot.android.poolparty;


import com.ocelot.android.poolparty.bout.Score;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ScoreTest {
    @Test
    public void testDefaultScore() throws Exception {
        int expected = 0;
        Score score  = new Score();

        assertEquals(expected, score.getScore());
    }

    @Test
    public void testInitialScore() throws Exception {
        int expected = 0;
        int input = 0;
        Score score = new Score();
        score.setScore(input);

        assertEquals(expected, score.getScore());
    }

    @Test
    public void testIncreaseScore() throws Exception {
        int expected = 1;

        Score score = new Score();
        score.increaseScore();

        assertEquals(expected, score.getScore());
    }

    @Test
    public void testDecreaseScore() throws Exception {
        int expected = 4;

        Score score = new Score();
        score.setScore(5);
        score.decreaseScore();

        assertEquals(expected, score.getScore());
    }

    @Test
    public void testDecreaseScore2() throws Exception {
        int expected = 0;

        Score score = new Score();
        score.setScore(0);
        score.decreaseScore();

        assertEquals(expected, score.getScore());
    }

    @Test
    public void testResetScore() throws Exception {
        int expected = 0;

        Score score = new Score(5);
        score.resetScore();

        assertEquals(expected, score.getScore());
    }

}
