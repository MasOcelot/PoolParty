package com.ocelot.android.poolparty.bout;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoutTimerTest {
    BoutTimer boutTimer;
    long startTimeMS = 180000;
    long tickRateMS = 10;

    @Before
    public void setUp() {
        boutTimer = new BoutTimer(startTimeMS, tickRateMS);
    }

    @Test
    public void testTimerConstructor() {
        long expectedCurrentTime = 180000;
        TimeState expectedTimerState = TimeState.RESET;

        assertEquals(expectedTimerState, boutTimer.getState());
        assertEquals(expectedCurrentTime, boutTimer.getCurrentTime());
    }

    @Test
    public void testSetTime() {
        long expectedTime0 = 65000;
        long expectedTime1 = 42500;
        long expectedTime2 = 0;
        TimeState expectedTimerState = TimeState.PAUSED;
        boutTimer.setCurrentTime(65000);
        assertEquals(expectedTime0, boutTimer.getCurrentTime());
        assertEquals(expectedTimerState, boutTimer.getState());
        boutTimer.setCurrentTime(42500);
        assertEquals(expectedTime1, boutTimer.getCurrentTime());
        boutTimer.setCurrentTime(-1000);
        assertEquals(expectedTime1, boutTimer.getCurrentTime());
        boutTimer.setCurrentTime(0);
        assertEquals(expectedTime2, boutTimer.getCurrentTime());
    }

    @Test
    public void testWaitTime() {

    }

    @Test
    public void testResetTimer() {
        int expectedTime0 = 30000;
        int expectedTime1 = 180000;
        TimeState expectedTimerState = TimeState.RESET;

        boutTimer.setCurrentTime(30000);
        assertEquals(expectedTime0, boutTimer.getCurrentTime());
        boutTimer.resetTime();
        assertEquals(expectedTime1, boutTimer.getCurrentTime());
        assertEquals(expectedTimerState, boutTimer.getState());
    }

    @Test
    public void testTimeout() throws InterruptedException {
        int expectedTime = 0;
        TimeState expectedTimerState = TimeState.TIMEOUT;

        boutTimer.setCurrentTime(3000);
        boutTimer.startTimer();
        // wait 3 seconds
        Thread.sleep(3100);
        assertEquals(expectedTime, boutTimer.getCurrentTime());
        assertEquals(expectedTimerState, boutTimer.getState());
    }

    @Test
    public void testRunningState() {
        TimeState expectedTimerState0 = TimeState.RUNNING;
        TimeState expectedTimerState1 = TimeState.PAUSED;

        boutTimer.startTimer();
        assertEquals(expectedTimerState0, boutTimer.getState());
        boutTimer.pauseTimer();
        assertEquals(expectedTimerState1, boutTimer.getState());
    }

}
