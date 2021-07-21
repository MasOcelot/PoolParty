package com.ocelot.android.poolparty.fencer;

public class Fencer {

    private static int numFencers = 0;

    private int index;
    private Score[] scores;
    private FencerID fencerID;
    private CompetitiveSpecs compSpecs;

    public Fencer(FencerID fencerID, int numCompetitors) {
        this.index = numFencers;
        numFencers++;
        this.scores = new Score[numCompetitors];
        initializeScores();
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

    public CompetitiveSpecs getCompSpecs() {
        if (this.compSpecs == null) {
            compSpecs = new CompetitiveSpecs();
        }
        return compSpecs;
    }

    public void setCompSpecs(CompetitiveSpecs compSpecs) {
        this.compSpecs = compSpecs;
    }

    public void setRating(Rating rating) {
        if (this.compSpecs == null) {
            compSpecs = new CompetitiveSpecs();
        }
        compSpecs.setRating(rating);
    }

    public Rating getRating() {
        if (this.compSpecs == null) {
            return null;
        }
        return compSpecs.getRating();
    }

    public void setClub(String club) {
        if (this.compSpecs == null) {
            compSpecs = new CompetitiveSpecs();
        }
        compSpecs.setClub(club);
    }

    public String getClub() {
        if (this.compSpecs == null) {
            return null;
        }
        return compSpecs.getClub();
    }

    private void initializeScores() {
        for (int i=0; i<scores.length; i++) {
            scores[i] = new Score();
        }
    }

    public Score[] getScores() {
        return scores;
    }

    public void setScore(int index, int score) {
        if (scores[index] == null) {
            return;
        }
        scores[index].setValue(score);
    }

    public int getScore(int index) {
        if (scores[index] == null) {
            return 0;
        }
        return scores[index].getValue();
    }

    public void increaseScore(int index) {
        this.scores[index].increaseScore();
    }

    public void decreaseScore(int index) {
        this.scores[index].decreaseScore();
    }

    public Cards getCards(int index) {
        if (scores[index] == null) {
            return null;
        }
        return scores[index].getCards();
    }

    public CardType addCard(int index, CardType cardType) {
        if (scores[index] == null) {
            return CardType.NONE;
        }
        return scores[index].addCard(cardType);
    }

    public void removeCard(int index, CardType cardType) {
        if (scores[index] == null) {
            return;
        }
        this.scores[index].removeCard(cardType);
    }
}
