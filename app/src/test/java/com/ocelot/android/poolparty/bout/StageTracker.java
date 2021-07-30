package com.ocelot.android.poolparty.bout;

public class StageTracker {
    private Stage stage;
    private int scoreLimit;
    private int maxEncounters;
    private int encounter;
    private boolean scoring;
    private boolean carding;

    public StageTracker() {
        this.stage = Stage.PREBOUT;
        this.scoreLimit = 15;
        this.maxEncounters = 3;
        this.encounter = 0;
        this.carding = true;
        this.scoring = true;
    }

    public void nextStage() {
        switch (this.stage) {
            case PREBOUT:
                this.stage = stage.pauseState();
                return;
            case PAUSE:
                return;
        }
    }

    public boolean isScoring() {
        return scoring;
    }

    public boolean isCarding() {
        return carding;
    }
}
