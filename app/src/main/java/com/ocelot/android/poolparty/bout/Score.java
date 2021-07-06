package com.ocelot.android.poolparty.bout;

public class Score {
    private int score;

    public Score(int score) {
        this.score = score;
    }

    public Score() {
        this(0);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public void decreaseScore() {
        if (score > 0) {
            this.score -= 1;
        }
    }
}
