package com.ocelot.android.poolparty.fencer;

public class Fencer {

    private Score[] score;
    private FencerID fencerID;
    private CompetitiveSpecs compSpecs;

    public Fencer(String firstName, String lastName, Hand hand, int numCompetitors) {
        this.score = new Score[numCompetitors];
        this.fencerID = new FencerID(firstName, lastName, hand);
    }

}
