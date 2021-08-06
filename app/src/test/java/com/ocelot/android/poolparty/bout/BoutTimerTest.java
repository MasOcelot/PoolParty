package com.ocelot.android.poolparty.bout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoutTimerTest {
    BoutTimer boutTimer;
    long startTimeMS = 180000;
    long tickRateMS = 1;


    @Before
    public void setUp() {
        boutTimer = new BoutTimer(startTimeMS, tickRateMS);
    }

    @Test
    public void testTimerConstructor() {
        long expectedCurrentTime = 180000;
        TimerState expectedTimerStage = BTimerState.INITIALIZED;

        assertEquals(expectedTimerState, boutTimer.getState);
        assertEquals(expectedCurrentTime, boutTimer.getCurrTime);
    }

}
