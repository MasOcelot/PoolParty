package com.ocelot.android.poolparty;


import com.ocelot.android.poolparty.bout.Score;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScoreTest {
    @Test
    public void testDefaultScore() throws Exception {
        int expected = 0;
        Score score  = new Score();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testInitialScore() throws Exception {
        int expected = 0;
        int input = 0;
        Score score = new Score();
        score.setValue(input);

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testIncreaseScore() throws Exception {
        int expected = 1;

        Score score = new Score();
        score.increaseScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testDecreaseScore() throws Exception {
        int expected = 4;

        Score score = new Score();
        score.setValue(5);
        score.decreaseScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testDecreaseScore2() throws Exception {
        int expected = 0;

        Score score = new Score();
        score.setValue(0);
        score.decreaseScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testResetScore() throws Exception {
        int expected = 0;

        Score score = new Score(5);
        score.resetScore();

        assertEquals(expected, score.getValue());
    }

    @Test
    public void testIsEqualTrue() throws Exception {
        Score score1 = new Score(5);
        Score score2 = new Score(5);

        assertTrue(score1.isEqual(score2));
    }

    @Test
    public void testIsEqualFalse() throws Exception {
        Score score1 = new Score(0);
        Score score2 = new Score(1);

        assertFalse(score1.isEqual(score2));
    }

}
