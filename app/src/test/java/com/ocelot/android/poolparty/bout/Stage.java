package com.ocelot.android.poolparty.bout;

public enum Stage {
    PREBOUT {
    },

    ENCOUNTER {
    },

    PAUSE {
    },

    BREAK {
    },

    POSTBOUT {
    };
    
    public abstract Stage nextStage(Bout bout);
}
