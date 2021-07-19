package com.ocelot.android.poolparty.fencer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FencerTest {
    private Fencer fencer;

    @Before
    public void setUp() {
        FencerID fencerID = new FencerID();
        fencer = new Fencer(fencerID);
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

        FencerID fencerID2 = new FencerID("A", "Harioka", Hand.LEFT);
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

}
