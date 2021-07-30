package com.ocelot.android.poolparty.bout;

import com.ocelot.android.poolparty.fencer.Fencer;

public class Bout {

    private Fencer rightFencer;
    private Fencer leftFencer;
    private int rightIndex;
    private int leftIndex;
    private StageTracker stageTracker;

    public Bout(Fencer rightFencer, Fencer leftFencer, int rightIndex, int leftIndex) throws Exception {
        if (rightIndex == leftIndex) {
            throw new Exception(); //"Fencer cannot fence themselves (", rightIndex, " vs. ", leftIndex, ")"
        }
        this.rightFencer = rightFencer;
        this.leftFencer = leftFencer;
        this.rightIndex = rightIndex;
        this.leftIndex = leftIndex;
        this.stageTracker = new StageTracker();
    }

    public Fencer getLeftFencer() {
        return leftFencer;
    }

    public Fencer getRightFencer() {
        return rightFencer;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void increaseLeft() {
        if (this.stageTracker.isScoring()) {
            leftFencer.increaseScore();
        }
    }

    public void increaseRight() {
        if (this.stageTracker.isScoring()) {
            rightFencer.increaseScore();
        }
    }
}
