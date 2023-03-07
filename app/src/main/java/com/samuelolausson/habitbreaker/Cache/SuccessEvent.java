package com.samuelolausson.habitbreaker.Cache;


public class SuccessEvent extends Event {
    public SuccessEvent(int day, String month, int year, EmotionalState[] emotionalState, String reasoning, String time, String amPm, double latitude,double longitude) {
        super(day, month, year, emotionalState, reasoning, time, amPm, latitude, longitude);
    }
}
