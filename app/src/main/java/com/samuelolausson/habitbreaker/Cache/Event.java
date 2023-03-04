package com.samuelolausson.habitbreaker.Cache;

import android.location.Location;

import java.util.Date;

public class Event {

    enum EmotionalState {
        HAPPY,
        SAD,
        ANGRY,
        DISAPPOINTED,
        BORED, // Feel free to add more options
    }

    Date date;
    EmotionalState emotionalState;
    Location location;

    public Event(Date date, EmotionalState emotionalState, Location location) {
        this.date = date;
        this.emotionalState = emotionalState;
        this.location = location;
    }
}
