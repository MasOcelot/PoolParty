package com.ocelot.android.poolparty.bout;

import android.os.CountDownTimer;

public class StageTracker {
    private Stage stage;
    private int scoreLimit;
    private int maxEncounters;
    private int encounter;
    private boolean scoring;
    private boolean carding;
    private CountDownTimer actionTimer;
    private CountDownTimer breakTimer;
    private CountDownTimer cardTimer;
    private final long timeBreak;
    private final long timeAction;
    private final long timeCard;

    public StageTracker(long timeAction, long timeBreak, long timeCard) {
        this.stage = Stage.PREBOUT;
        this.scoreLimit = 15;
        this.maxEncounters = 3;
        this.encounter = 0;
        this.carding = true;
        this.scoring = true;
        this.timeAction = timeAction;
        this.timeBreak = timeBreak;
        this.timeCard = timeCard;
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

    private void initiateTimers() {
        this.actionTimer = new CountDownTimer(timeAction, 10) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };
    }

    public boolean isScoring() {
        return scoring;
    }

    public boolean isCarding() {
        return carding;
    }
}
