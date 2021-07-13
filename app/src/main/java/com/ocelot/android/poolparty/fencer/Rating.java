package com.ocelot.android.poolparty.fencer;

public enum Rating {
    U, E, D, C, B, A;

    public Boolean isEquals(Rating rating) {
        if (this == rating) {
            return true;
        }
        return false;
    }
}
