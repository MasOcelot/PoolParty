package com.ocelot.android.poolparty.bout;

public enum Stage {
    PREBOUT {
        @Override
        public Stage encounterState() {
            return ENCOUNTER;
        }

        @Override
        public Stage pauseState() {
            return this;
        }

        @Override
        public Stage breakState() {
            return BREAK;
        }

        @Override
        public Stage preBoutState() {
            return PREBOUT;
        }

        @Override
        public Stage postBoutState() {
            return POSTBOUT;
        }
    },
    ENCOUNTER {
        @Override
        public Stage encounterState() {
            return this;
        }

        @Override
        public Stage pauseState() {
            return PAUSE;
        }

        @Override
        public Stage breakState() {
            return BREAK;
        }

        @Override
        public Stage preBoutState() {
            return PREBOUT;
        }

        @Override
        public Stage postBoutState() {
            return POSTBOUT;
        }
    },

    PAUSE {
        @Override
        public Stage encounterState() {
            return ENCOUNTER;
        }

        @Override
        public Stage pauseState() {
            return this;
        }

        @Override
        public Stage breakState() {
            return BREAK;
        }

        @Override
        public Stage preBoutState() {
            return PREBOUT;
        }

        @Override
        public Stage postBoutState() {
            return POSTBOUT;
        }
    },
    BREAK {
        @Override
        public Stage encounterState() {
            return ENCOUNTER;
        }

        @Override
        public Stage pauseState() {
            return PAUSE;
        }

        @Override
        public Stage breakState() {
            return this;
        }

        @Override
        public Stage preBoutState() {
            return PREBOUT;
        }

        @Override
        public Stage postBoutState() {
            return POSTBOUT;
        }
    },
    POSTBOUT{
        @Override
        public Stage encounterState() {
            return ENCOUNTER;
        }

        @Override
        public Stage pauseState() {
            return PAUSE;
        }

        @Override
        public Stage breakState() {
            return BREAK;
        }

        @Override
        public Stage preBoutState() {
            return PREBOUT;
        }

        @Override
        public Stage postBoutState() {
            return this;
        }
    };

    public abstract Stage preBoutState();
    public abstract Stage encounterState();
    public abstract Stage pauseState();
    public abstract Stage breakState();
    public abstract Stage postBoutState();
}
