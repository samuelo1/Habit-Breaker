package com.samuelolausson.habitbreaker.Cache;

import android.location.Location;

import java.util.Date;

public class FailureEvent extends Event {
    public FailureEvent(Date date, EmotionalState emotionalState, Location location) {
        super(date, emotionalState, location);
    }
}
