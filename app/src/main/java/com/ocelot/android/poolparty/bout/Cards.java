package com.ocelot.android.poolparty.bout;

import androidx.annotation.Nullable;

public class Cards {
    private int yellow;
    private int red;
    private int black;

    public Cards() {
        this.yellow = 0;
        this.red = 0;
        this.black = 0;
    }

    public void addYellow() {
        if (this.yellow == 0) {
            this.yellow++;
            //Return Yellow
        } else {
            this.addRed();
        }
    }

    public void addRed() {
        this.red++;
        // return Red
    }

    public void addBlack() {
        this.black++;
        // return Black
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
}
