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
        assertTrue(stageTracker.getIsAwarding());
    }

    @Test
    public void testPauseEncounter() {
        BoutStage expectedCurrentStage = BoutStage.Paused;
        BoutStage expectedNextUnpause = BoutStage.Encounter;
        int expectedCurrentEncounter = 0;

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

        assertEquals(expectedCurrentEncounter, stageTracker.getCurrEncounter());
        assertEquals(expectedCurrentStage, stageTracker.getCurrentStage());
        assertEquals(expectedNextUnpause, stageTracker.getNextUnpause());
        assertTrue(stageTracker.getIsAwarding());
    }


}
