package com.ocelot.android.poolparty.bout;

import android.os.CountDownTimer;

public class StageTracker {
    private static Stage stage;
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
    private Bout bout;

    public StageTracker(Bout bout, long timeAction, long timeBreak, long timeCard) {
        this.stage = Stage.PREBOUT;
        this.scoreLimit = 15;
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

    public void nextStage() {
        switch (this.stage) {
            case PREBOUT:
                this.stage = stage.pauseState();
                encounter++;
                return;
            case PAUSE:
                return;
        }
    }

    private void actionFinish() {
        if (stage == Stage.ENCOUNTER) {
            if (encounter < maxEncounters) {
                stage.breakState();
            }
        }
    };

    private void initiateTimers() {
        this.actionTimer = new CountDownTimer(timeAction, 1) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                actionFinish();
            }
        };

        this.breakTimer = new CountDownTimer(timeBreak, 1) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };

        this.cardTimer = new CountDownTimer(timeCard, 1) {
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

    private void setStage(Stage newStage) {
        switch (newStage) {
            case PREBOUT:
                abcCardScore(false, false, false, false, false);
                break;
            case PAUSE:
                abcCardScore(false, false, false, true, true);
                break;
            case ENCOUNTER:
                abcCardScore(true, false, false, false, false);
                break;
            case POSTBOUT:
                abcCardScore(false, false, false, true, true);
                break;
            case BREAK:
                abcCardScore(false, true, false, true, true);
                break;
        }
        this.stage = newStage;
    }

    private void abcCardScore(boolean action, boolean rest, boolean card, boolean carding, boolean scoring) {
        if (action) {
            actionTimer.start();
        } else {
            actionTimer.cancel();
        }
        if (rest) {
            breakTimer.start();
        } else {
            breakTimer.cancel();
        }
        if (card) {
            cardTimer.start();
        } else {
            cardTimer.cancel();
        }
        this.carding = carding;
        this.scoring = scoring;
    }
}
