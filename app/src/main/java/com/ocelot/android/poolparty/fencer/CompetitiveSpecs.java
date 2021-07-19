package com.ocelot.android.poolparty.fencer;

public class CompetitiveSpecs {
    private String club;
    private Rating rating;

    public CompetitiveSpecs(String club, Rating rating) {
        this.club = club;
        this.rating = rating;
    }

    public CompetitiveSpecs() {
        this("", Rating.U);
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getClub() {
        return club;
    }

    public Rating getRating() {
        return rating;
    }
}
