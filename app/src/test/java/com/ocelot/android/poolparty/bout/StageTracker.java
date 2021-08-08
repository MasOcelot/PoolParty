package com.ocelot.android.poolparty.bout;

import android.os.CountDownTimer;

public class StageTracker {
    private Stage stage;
    private int scoreLimit;
    private int maxEncounters;
    private int encounter;
    private boolean scoring;
    private boolean carding;
    private BoutTimer actionTimer;
    private BoutTimer breakTimer;
    private BoutTimer cardTimer;
    private final long timeBreak;
    private final long timeAction;
    private final long timeCard;
    private Bout bout;

    public StageTracker(Bout bout, long timeAction, long timeBreak, long timeCard) {
        this.stage = Stage.PREBOUT;
        this.scoreLimit = 0;
        this.maxEncounters = 3;
        this.encounter = 0;
        this.carding = true;
        this.scoring = true;
        this.timeAction = timeAction;
        this.timeBreak = timeBreak;
        this.timeCard = timeCard;
        this.bout = bout;
    }

    public StageTracker(Bout bout) {
        this(bout, 180000, 60000, 60000);
    }

    public void setScoreLimit(int scoreLimit) {
        this.scoreLimit = scoreLimit;
    }

    public int getScoreLimit() {
        return scoreLimit;
    }

    public boolean isScoring() {
        return scoring;
    }

    public boolean isCarding() {
        return carding;
    }

    private void enterStage(Stage newStage) {
        switch (newStage) {
            case PREBOUT:
                abcCardScore(false, false, false, false, false);
                break;
            case POSTBOUT:
            case PAUSE:
                abcCardScore(false, false, false, true, true);
                break;
            case ENCOUNTER:
                abcCardScore(true, false, true, false, false);
                break;
            case BREAK:
                abcCardScore(false, true, false, true, true);
                break;
        }
        this.stage = newStage;
    }

    private void abcCardScore(boolean action, boolean rest, boolean card, boolean carding, boolean scoring) {
        if (action) {
            actionTimer.startTimer();
        } else {
            actionTimer.pauseTimer();
        }
        if (rest) {
            breakTimer.startTimer();
        } else {
            breakTimer.pauseTimer();
        }
        if (card) {
            cardTimer.startTimer();
        } else {
            cardTimer.pauseTimer();
        }
        this.carding = carding;
        this.scoring = scoring;
    }

    public void handlePostInit() {
        switch (stage) {
            case PREBOUT:
                enterStage(Stage.PAUSE);
        }
    }

    public void handleStartActionTimer() {
        switch (stage) {
            case PAUSE:
                enterStage(Stage.ENCOUNTER);
        }

    }

    public void handlePauseActionTimer() {
        switch (stage) {
            case ENCOUNTER:
                enterStage(Stage.PAUSE);
        }

    }

    public void handlePeriodScore() {
        switch (stage) {
            case ENCOUNTER:
                if (encounter < maxEncounters-1) {
                    enterStage(Stage.BREAK);
                } else {
                    enterStage(Stage.POSTBOUT);
                }
                break;
        }
    }

    public void handlePeriodTime() {
        switch (stage) {
            case ENCOUNTER:
                if (encounter < maxEncounters-1) {
                    enterStage(Stage.BREAK);
                } else {
                    enterStage(Stage.POSTBOUT);
                }
                break;
            default:
                break;
        }
    }

    public void handleEndBreakTime() {
        switch (stage) {
            case BREAK:
                encounter++;
                enterStage(Stage.PAUSE);
        }
    }

    public void handleSkipBreak() {
        switch (stage) {
            case BREAK:
                encounter++;
                enterStage(Stage.PAUSE);
        }
    }

    public void handleScoreLimit() {
        switch (stage) {
            case PAUSE:
            case ENCOUNTER:
            case BREAK:
                enterStage(Stage.POSTBOUT);
        }
    }

    public void resetBout() {
        switch (stage) {
            case PAUSE:
            case BREAK:
            case POSTBOUT:
                encounter = 0;

        }
    }
}
