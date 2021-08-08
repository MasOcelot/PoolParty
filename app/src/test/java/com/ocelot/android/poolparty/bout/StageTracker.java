package com.ocelot.android.poolparty.bout;

public class StageTracker {
    private Stage stage;
    private int scoreLimit;
<<<<<<< Updated upstream
    private int encounters;
=======
    private int maxEncounters;
    private int encounter;
    private boolean scoring;
    private boolean carding;
    private TimerTracker actionTimer;
    private TimerTracker breakTimer;
    private TimerTracker cardTimer;
//    private CountDownTimer actionCDT;
//    private CountDownTimer breakCDT;
//    private CountDownTimer cardCDT;
    private final long timeBreak;
    private final long timeAction;
    private final long timeCard;
    private Bout bout;
>>>>>>> Stashed changes

    public StageTracker() {
        this.stage = Stage.PREBOUT;
        this.scoreLimit = 15;
        this.encounters = 2;
    }
}
