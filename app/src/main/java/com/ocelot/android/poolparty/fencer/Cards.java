package com.ocelot.android.poolparty.fencer;

import androidx.annotation.NonNull;

public class Cards {
    private int yellow;
    private int red;
    private int black;

    public Cards() {
        this.yellow = 0;
        this.red = 0;
        this.black = 0;
    }

    public CardType addYellow() {
        if (this.yellow == 0) {
            this.yellow++;
            return CardType.YELLOW;
        } else {
            return this.addRed();
        }
    }

    public CardType addRed() {
        this.red++;
        return CardType.RED;
    }

    public CardType addBlack() {
        this.black++;
        return CardType.BLACK;
    }

    public int getYellow() {
        return yellow;
    }

    public int getRed() {
        return red;
    }

    public int getBlack() {
        return black;
    }

    public void setYellow(int yellow) {
        if (yellow > 1){
            this.yellow = 1;
        } else if (yellow < 0) {
            this.yellow = 0;
        } else {
            this.yellow = yellow;
        }
    }

    public void setRed(int red) {
        if (red < 0) {
            this.red = 0;
            return;
        }
        this.red = red;
    }

    public void setBlack(int black) {
        if (black < 0) {
            this.black = 0;
            return;
        }
        this.black = black;
    }

    public void removeYellow() {
        if (yellow > 0) {
            yellow--;
        }
    }

    public void removeRed() {
        if (red > 0) {
            red--;
        }
    }

    public void removeBlack() {
        if (black > 0) {
            black--;
        }
    }

    public boolean isEqual(Cards cards) {
        if (cards != null) {
            if (cards.getBlack() == this.getBlack() &&
                cards.getYellow() == this.getYellow() &&
                cards.getRed() == this.getRed()) {
                return true;
            }
            return false;
        } else {
            throw new NullPointerException("Parameter 'cards' cannot be null.");
        }
    }

    @NonNull
    @Override
    public String toString() {
        String output = "";
        output += "Yellow: " + this.yellow;
        output += " | Red: " + this.red;
        output += " | Black: " + this.black;
        return output;
    }
}
