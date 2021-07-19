package com.ocelot.android.poolparty.fencer;

public enum Rating {
    U, E, D, C, B, A;

    public Boolean isEqual(Rating rating) {
        if (this == rating) {
            return true;
        }
        return false;
    }
}
