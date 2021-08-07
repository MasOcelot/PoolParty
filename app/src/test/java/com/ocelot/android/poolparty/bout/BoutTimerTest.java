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
        TimerState expectedTimerState = TimerState.RESET;

        assertEquals(expectedTimerState, boutTimer.getState);
        assertEquals(expectedCurrentTime, boutTimer.getCurrTime);
    }

    @Test
    public void testSetTime() {
        int expectedTime0 = 65000;
        int expectedTime1 = 42500;
        int expectedTime2 = 0;
        TimerState expectedTimerState = TimerState.PAUSED;
        boutTimer.setCurrTime(65000);
        assertEquals(expectedTime0, boutTimer.getCurrTime());
        assertEquals(expectedTimerState, boutTimer.getState());
        boutTimer.setCurrTime(42500);
        assertEquals(expectedTime1, boutTimer.getCurrTime());
        boutTimer.setCurrTime(-1000);
        assertEquals(expectedTime1, boutTimer.getCurrTime());
        boutTimer.setCurrTime(0);
        assertEquals(expectedTime2, boutTimer.getCurrTime());
    }

    @Test
    public void testWaitTime() {

    }

    @Test
    public void testResetTimer() {
        int expectedTime0 = 30000;
        int expectedTime1 = 180000;
        TimerState expectedTimerState = TimerState.RESET;

        boutTimer.setCurrTime(30000);
        assertEquals(expectedTime0, boutTimer.getCurrTime());
        boutTimer.resetTime();
        assertEquals(expectedTime1, boutTimer.getCurrTime());
        assertEquals(expectedTimerState, boutTimer.getState());
    }

    @Test
    public void testTimeout() throws InterruptedException {
        int expectedTime = 0;
        TimerState expectedTimerState = TimerState.TIMEOUT;

        boutTimer.setCurrTime(3000);
        // wait 3 seconds
        Thread.sleep(3100);
        assertEquals(expectedTime, boutTimer.getCurrTime());
        assertEquals(expectedTimerState, boutTimer.getState());
    }

    @Test
    public void testRunningState() {
        TimerState expectedTimerState0 = TimerState.RUNNING;
        TimerState expectedTimerState1 = TimerState.PAUSED;

        boutTimer.startTimer();
        assertEquals(expectedTimerState0, boutTimer.getState());
        boutTimer.pauseTimer();
        assertEquals(expectedTimerState1, boutTimer.getState());
    }

}
