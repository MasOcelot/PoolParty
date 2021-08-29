package com.ocelot.android.poolparty.bout;

import androidx.annotation.NonNull;

import com.ocelot.android.poolparty.fencer.CardType;
import com.ocelot.android.poolparty.fencer.Fencer;
import com.ocelot.android.poolparty.fencer.Score;

public class Bout {

    private final Fencer rightFencer;
    private final Fencer leftFencer;
    private final int rightIndex;
    private final int leftIndex;
    private final StageTracker stageTracker;

    public Bout(Fencer rightFencer, Fencer leftFencer, int rightIndex, int leftIndex) throws Exception {
        if (rightIndex == leftIndex) {
            throw new Exception(); //"Fencer cannot fence themselves (", rightIndex, " vs. ", leftIndex, ")"
        }
        this.rightFencer = rightFencer;
        this.leftFencer = leftFencer;
        this.rightIndex = rightIndex;
        this.leftIndex = leftIndex;
        this.stageTracker = new StageTracker(this);
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
        if (leftFencer != null){
            if (this.stageTracker.isScoring() && stageTracker.getScoreLimit() > 0) {
                leftFencer.increaseScore(rightIndex);
                stageTracker.checkScore();
            }
        }
    }

    public void increaseRight() {
        if (rightFencer != null) {
            if (this.stageTracker.isScoring() && stageTracker.getScoreLimit() > 0) {
                rightFencer.increaseScore(leftIndex);
                stageTracker.checkScore();
            }
        }
    }

    public void doubleTouch() {
        if (stageTracker.getScoreLimit() != 0 ||
                (getLeftScore().getValue() == getRightScore().getValue()) && (getLeftScore().getValue() != stageTracker.getScoreLimit()-1)) {
            increaseLeft();
            increaseRight();
        }
    }

    public void decreaseLeft() {
        if (leftFencer != null) {
            if (this.stageTracker.isScoring()) {
                leftFencer.decreaseScore(rightIndex);
            }
        }
    }

    public void decreaseRight() {
        if (rightFencer != null) {
            if (this.stageTracker.isScoring()) {
                rightFencer.decreaseScore(leftIndex);
            }
        }
    }

    public void increaseScore(Side side) {
        switch (side) {
            case LEFT:
                this.increaseLeft();
                break;
            case RIGHT:
                this.increaseRight();
                break;
            case BOTH:
                this.increaseRight();
                this.increaseLeft();
                break;
        }
    }

    private Score getLeftScore() {
        if (leftFencer == null) {
            return null;
        }
        return leftFencer.getScores()[rightIndex];
    }

    private Score getRightScore() {
        if (rightFencer == null) {
            return null;
        }
        return rightFencer.getScores()[leftIndex];
    }

    public int getScore(Side side) {
        Score score = null;
        switch (side) {
            case RIGHT:
                score = this.getRightScore();
                break;
            case LEFT:
                score = this.getLeftScore();
                break;
        }
        if (score != null) {
            return score.getValue();
        }
        return -1;
    }

    private CardType cardLeft(CardType cardType) {
        if (leftFencer != null && this.stageTracker.isCarding()) {
            return this.getLeftFencer().addCard(rightIndex, cardType);
        }
        return CardType.NONE;
    }

    private CardType cardRight(CardType cardType) {
        if (rightFencer != null && this.stageTracker.isCarding()) {
            return this.getRightFencer().addCard(leftIndex, cardType);
        }
        return CardType.NONE;
    }

    public void addCard(Side side, CardType cardType) {
        CardType cardResult = CardType.NONE;
        switch (side) {
            case LEFT:
                cardResult = this.cardLeft(cardType);
                break;
            case RIGHT:
                cardResult = this.cardRight(cardType);
                break;
        }
        this.processCardResult(side, cardResult);
    }

    public int getCardCount(Side side, CardType cardType) {
        Score score = null;
        switch (side) {
            case RIGHT:
                score = this.getRightScore();
                break;
            case LEFT:
                score = this.getLeftScore();
                break;
        }
        if (score != null) {
            switch (cardType) {
                case NONE:
                    return -1;
                case YELLOW:
                    return score.getCards().getYellow();
                case RED:
                    return score.getCards().getRed();
                case BLACK:
                    return score.getCards().getBlack();
            }
        }
        return -1;
    }

    private void processCardResult(Side side, CardType cardType) {
        if (side == Side.BOTH) {
            return;
        }
        switch (cardType) {
            case YELLOW:
                return;
            case RED:
                Side oppositeSide = Side.NEITHER;
                if (side == Side.LEFT) {
                    oppositeSide = Side.RIGHT;
                } else if (side == Side.RIGHT) {
                    oppositeSide = Side.LEFT;
                }
                this.increaseScore(oppositeSide);
            case BLACK:
                endBout();
                return;
            case NONE:
                break;
        }
    }

    public void resetScores() {
        leftFencer.setScore(rightIndex, 0);
        rightFencer.setScore(leftIndex, 0);
    }

    public void endBout() {
        return;
    }

}
