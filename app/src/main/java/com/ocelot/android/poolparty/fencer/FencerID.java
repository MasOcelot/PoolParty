package com.ocelot.android.poolparty.fencer;

public class FencerID {

    private String firstName;
    private String lastName;
    private Hand hand;

    public FencerID(String firstName, String lastName, Hand hand) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hand = hand;
    }

    public FencerID() {
        this("First", "Last", Hand.RIGHT);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Hand getHand() {
        return hand;
    }
}
