package com.ocelot.android.poolparty.bout;

import androidx.annotation.Nullable;

public class Score {
    private int value;

    public Score(int score) {
        this.value = score;
    }

    public Score() {
        this(0);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increaseScore() {
        this.value += 1;
    }

    public void decreaseScore() {
        if (value > 0) {
            this.value -= 1;
        }
    }

    public void resetScore() {
        this.value = 0;
    }

    public boolean isEqual(Score score) throws NullPointerException {
        if (score != null) {
            if (score.value == this.value) {
                return true;
            } else {
                return false;
            }
        }
        throw new NullPointerException("Parameter 'value' cannot be null.");
    }

}
