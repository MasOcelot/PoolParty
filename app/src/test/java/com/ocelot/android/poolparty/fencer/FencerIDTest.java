package com.ocelot.android.poolparty.fencer;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class FencerIDTest {
    private FencerID fencerID;

    @Before
    public void setUp() {
        fencerID = new FencerID();
    }

    @Test
    public void testDefaultNames() {
        String expectedFirst = "First";
        String expectedLast = "Last";

        assertEquals(expectedFirst, fencerID.getFirstName());
        assertEquals(expectedLast, fencerID.getLastName());
    }

    @Test
    public void testDefaultHand() {
        Hand expectedHand = Hand.RIGHT;

        assertEquals(expectedHand, fencerID.getHand());
    }

    @Test
    public void testFirstName() {
        String expectedFirst = "Ahsoka";

        fencerID.setFirstName("Ahsoka");
        assertEquals(expectedFirst, fencerID.getFirstName());
    }

    @Test
    public void testLastName() {
        String expectedLast = "Tano";

        fencerID.setLastName("Tano");
        assertEquals(expectedLast, fencerID.getLastName());
    }

    @Test
    public void testHand() {
        Hand expectedHand = Hand.LEFT;

        fencerID.setHand(Hand.LEFT);
        assertEquals(expectedHand, Hand.LEFT);
        assertNotEquals(expectedHand, Hand.RIGHT);
    }
}
