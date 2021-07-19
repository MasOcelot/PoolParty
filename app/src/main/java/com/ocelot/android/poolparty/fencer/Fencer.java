package com.ocelot.android.poolparty.fencer;

public class Fencer {

    private Score[] score;
    private String firstName;
    private String lastName;
    private String club;
    private Hand dominantHand;
    private Rating rating;

    public Fencer(String firstName, String lastName, Hand dominantHand, Rating rating, int numCompetitors) {
        this.score = new Score[numCompetitors];
        this.firstName = firstName;
        this.lastName = lastName;
        this.dominantHand = dominantHand;
        this.rating = rating;
    }

}
