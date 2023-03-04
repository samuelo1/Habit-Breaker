package com.samuelolausson.habitbreaker.Cache;

import android.location.Location;

import java.util.Date;

public class SuccessEvent extends Event {
    public SuccessEvent(Date date, EmotionalState emotionalState, Location location) {
        super(date, emotionalState, location);
    }
}
