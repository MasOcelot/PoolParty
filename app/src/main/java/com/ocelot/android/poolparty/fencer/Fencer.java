package com.ocelot.android.poolparty.fencer;

public class Fencer {

    private static int numFencers = 0;

    private int index;
    private Score[] score;
    private FencerID fencerID;
    private CompetitiveSpecs compSpecs;

    public Fencer(FencerID fencerID, int numCompetitors) {
        this.index = numFencers;
        numFencers++;
        this.score = new Score[numCompetitors];
        this.fencerID = fencerID;
    }

    public Fencer(FencerID fencerID) {
        this(fencerID, 1);
    }

    private FencerID getFencerID() {
        return fencerID;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setFirstName(String firstName) {
        this.fencerID.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        this.fencerID.setLastName(lastName);
    }

    public void setHand(Hand hand) {
        this.fencerID.setHand(hand);
    }

    public int getIndex() {
        return index;
    }

    public String getFirstName() {
        FencerID fencerID = getFencerID();
        return fencerID.getFirstName();
    }

    public String getLastName() {
        FencerID fencerID = getFencerID();
        return fencerID.getLastName();
    }

    public Hand getHand() {
        FencerID fencerID = getFencerID();
        return fencerID.getHand();
    }

}
