package com.ocelot.android.poolparty.fencer;

public class Fencer {

    private Cards cards;
    private Score score;
    private String firstName;
    private String lastName;
    private String club;
    private Hand dominantHand;
    private Rating rating;

    public Fencer(String firstName, String lastName, Hand dominantHand, Rating rating) {
        this.score = new Score();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dominantHand = dominantHand;
        this.rating = rating;
    }

}
