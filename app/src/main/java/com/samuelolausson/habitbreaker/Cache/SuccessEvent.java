package com.samuelolausson.habitbreaker.Cache;

import android.location.Location;

import java.util.Date;

public class SuccessEvent extends Event {
    public SuccessEvent(int day, String month, int year, EmotionalState[] emotionalState, String location, String reasoning, String time, String amPm) {
        super(day, month, year, emotionalState, location, reasoning, time, amPm);
    }
}
