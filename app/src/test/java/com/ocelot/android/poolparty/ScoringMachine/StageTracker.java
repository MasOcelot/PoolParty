package com.ocelot.android.poolparty.ScoringMachine;

import com.ocelot.android.poolparty.bout.BreakType;

public class StageTracker {
    private boolean isAwarding;
    private BoutStage currentStage;
    private BoutStage nextUnpause;
    private int scoreLimit;
    private int maxEncounters;
    private int currentEncounter;
    private BreakType breakType;
}
