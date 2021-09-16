package com.ocelot.android.poolparty.ScoringMachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StageTrackerTest {
    StageTracker stageTracker;

    @Before
    public void setUp()
    {
        stageTracker = new StageTracker();
    }

    @Test
    public void testStageTrackerConstructor() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Encounter;
        int expectedCurrentEncounter = 0;

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }

    @Test
    public void testStartEncounter() {
        BoutStage expectedCurrentStage = BoutStage.Encounter;
        BoutStage expectedNextUnpause = BoutStage.Encounter;
        int expectedCurrentEncounter = 0;

        // Do we track which timer is active?

        stageTracker.toggleTimer();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertFalse(stageTracker.getIsAwarding());
    }

    @Test
    public void testPauseEncounter() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Encounter;
        int expectedCurrentEncounter = 0;

        stageTracker.toggleTimer();
        stageTracker.toggleTimer();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }

    @Test
    public void testStopEncounterTimeout() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Break;
        int expectedCurrentEncounter = 0;

        stageTracker.toggleTimer();
        stageTracker.encounterTimeout();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }

    @Test
    public void testStopEncounterManualStop() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Break;
        int expectedCurrentEncounter = 0;

        stageTracker.toggleTimer();
        stageTracker.encounterManualStop();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }

    @Test
    public void testStartBreak() {
        BoutStage expectedCurrentStage = BoutStage.Break;
        BoutStage expectedNextUnpause = BoutStage.Break;
        int expectedCurrentEncounter = 0;

        stageTracker.skipToStage(BoutStage.Break);
        stageTracker.toggleTimer();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertFalse(stageTracker.getIsAwarding());
    }

    @Test
    public void testPauseBreak() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Break;
        int expectedCurrentEncounter = 0;

        stageTracker.skipToStage(BoutStage.Break);
        stageTracker.toggleTimer();
        stageTracker.toggleTimer();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }

    @Test
    public void testStopBreakTimeout() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Encounter;
        int expectedCurrentEncounter = 1;

        stageTracker.skipToStage(BoutStage.Break);
        stageTracker.toggleTimer();
        stageTracker.breakTimeout();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }

    @Test
    public void testStopBreakManualStop() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Encounter;
        int expectedCurrentEncounter = 1;

        stageTracker.skipToStage(BoutStage.Break);
        stageTracker.toggleTimer();
        stageTracker.breakManualStop();

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }


}
