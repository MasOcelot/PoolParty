package com.ocelot.android.poolparty.fencer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompetitiveSpecsTest {
    CompetitiveSpecs compSpec;

    @Before
    public void setUp() {
        compSpec = new CompetitiveSpecs();
    }

    @Test
    public void testEmptySpec() {
        assertEquals(Rating.U, compSpec.getRating());
        assertEquals("", compSpec.getClub());
    }

    @Test
    public void testNewClub() {
        String expectedClub = "PFA";
        compSpec.setClub(expectedClub);

        assertEquals(expectedClub, compSpec.getClub());
    }

    @Test
    public void testNewClub2() {
        String club1 = "PFA";
        String expectedClub = "UCSC";
        compSpec.setClub(club1);
        compSpec.setClub(expectedClub);

        assertEquals(expectedClub, compSpec.getClub());
    }

    @Test
    public void testNewRating() {
        Rating expectedRating = Rating.C;

        compSpec.setRating(Rating.C);

        assertEquals(expectedRating, compSpec.getRating());
    }
}
