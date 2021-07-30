package com.ocelot.android.poolparty;

import com.ocelot.android.poolparty.bout.Bout;
import com.ocelot.android.poolparty.fencer.Fencer;
import com.ocelot.android.poolparty.fencer.FencerID;
import com.ocelot.android.poolparty.fencer.Hand;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class BoutTest {
    private FencerID id1;
    private FencerID id2;
    private Fencer fencer1;
    private Fencer fencer2;
    private Bout bout;

    @Before
    public void setUp() {
        id1 = new FencerID("Mark", "Hamill", Hand.RIGHT);
        id2 = new FencerID("Harrison", "Ford", Hand.RIGHT);
        fencer1 = new Fencer(id1);
        fencer2 = new Fencer(id2);
        try {
            bout = new Bout(fencer1, fencer2, 0, 1);
        } catch (Exception e) {

        }
    }

    @Test
    public void testNames() {
        String expectedLeftName = "Ford";
        String expectedRightName = "Hamill";

        assertEquals(expectedLeftName, bout.getLeftFencer().getLastName());
        assertEquals(expectedRightName, bout.getRightFencer().getLastName());
    }

}
