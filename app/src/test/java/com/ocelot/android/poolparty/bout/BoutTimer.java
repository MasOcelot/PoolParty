package com.ocelot.android.poolparty.bout;

import android.os.CountDownTimer;

public class BoutTimer {
    private long startTime;
    private long currentTime;
    private long tickRate;
    private TimeState timeState;
    private CountDownTimer countDownTimer;

    public BoutTimer(long startTimeMS, long tickRateMS) {
        this.startTime = startTimeMS;
        this.currentTime = startTimeMS;
        this.tickRate = tickRateMS;
        this.timeState = TimeState.RESET;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        if (currentTime >= 0) {
            this.currentTime = currentTime;
            if (currentTime != startTime) {
                setTimeState(TimeState.PAUSED);
            }
        }
    }

    public TimeState getState() {
        return timeState;
    }

    public void setTimeState(TimeState timeState) {
        this.timeState = timeState;
    }

    public void startTimer() {
        this.countDownTimer = new CountDownTimer(this.currentTime, this.tickRate) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentTime = millisUntilFinished;
            }

            @Override
            public void onFinish() {
                setTimeState(TimeState.TIMEOUT);
            }
        }.start();
    }

    public void pauseTimer() {
        if (countDownTimer!=null) {
            countDownTimer.cancel();
        }
        setTimeState(TimeState.PAUSED);
    }

    public void resetTime() {
        if (timeState == TimeState.RUNNING) {
            pauseTimer();
        }
        currentTime = startTime;
        setTimeState(TimeState.RESET);
    }


}
