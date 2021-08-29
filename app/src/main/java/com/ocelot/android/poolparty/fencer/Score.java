package com.ocelot.android.poolparty.fencer;

import android.support.v4.os.IResultReceiver;

public class Score {
    private int value;
    private boolean victory;
    private Cards cards;
    private Cards pCards;

    public Score(int score) {
        this.value = score;
        this.victory = false;
        this.cards = new Cards();
        this.pCards = new Cards();
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

    public void setCards(CardType cardType, int numCards) {
        switch (cardType) {
            case YELLOW:
                cards.setYellow(numCards);
                break;
            case RED:
                cards.setRed(numCards);
                break;
            case BLACK:
                cards.setBlack(numCards);
                break;
        }
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

    public void removeCard(CardType card) {
        switch (card) {
            case YELLOW:
                this.cards.removeYellow();
                break;
            case RED:
                this.cards.removeRed();
                break;
            case BLACK:
                this.cards.removeBlack();
                break;
        }
    }

    public Cards getPCards() {
        return this.pCards;
    }

    public void setPCards(CardType cardType, int numCards) {
        switch (cardType) {
            case YELLOW:
                pCards.setYellow(numCards);
                break;
            case RED:
                pCards.setRed(numCards);
                break;
            case BLACK:
                pCards.setBlack(numCards);
                break;
        }
    }

    public CardType addPCard(CardType card){
        switch (card) {
            case YELLOW:
                return this.pCards.addYellow();
            case RED:
                return this.pCards.addRed();
            case BLACK:
                return this.pCards.addBlack();
        }
        return CardType.NONE;
    }

    public void removePCard(CardType card) {
        switch (card) {
            case YELLOW:
                this.pCards.removeYellow();
                break;
            case RED:
                this.pCards.removeRed();
                break;
            case BLACK:
                this.pCards.removeBlack();
                break;
        }
    }




}
