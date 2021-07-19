package com.ocelot.android.poolparty.fencer;

import android.support.v4.os.IResultReceiver;

public class Score {
    private int value;
    private boolean victory;
    private Cards cards;

    public Score(int score) {
        this.value = score;
        this.victory = false;
        this.cards = new Cards();
    }

    public Score() {
        this(0);
    }

    public boolean getVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public void setVictory() {
        this.setVictory(true);
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

    public Cards getCards() {
        return this.cards;
    }

    public CardType addCard(CardType card){
        switch (card) {
            case YELLOW:
                return this.cards.addYellow();
            case RED:
                return this.cards.addRed();
            case BLACK:
                return this.cards.addBlack();
        }
        return CardType.NONE;
    }




}
