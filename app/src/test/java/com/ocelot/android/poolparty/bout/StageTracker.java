package com.ocelot.android.poolparty.bout;

public class StageTracker {
    private Stage stage;
    private int scoreLimit;
    private int encounters;

    public StageTracker() {
        this.stage = Stage.PREBOUT;
        this.scoreLimit = 15;
        this.encounters = 2;
    }
}
