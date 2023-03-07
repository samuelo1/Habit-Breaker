package com.samuelolausson.habitbreaker.Cache;

import java.time.LocalDateTime;
import java.time.Month;

public class Event {

    public enum EmotionalState {
        HAPPY,
        SAD,
        ANGRY,
        DISAPPOINTED,
        BORED,
        LONELY,
    }

    LocalDateTime dateTime;
    EmotionalState[] emotionalState;
    String location;
    String reasoning;

    String time;
    String amPm;

    public Event(LocalDateTime dateTime, EmotionalState[] emotionalState, String location, String reasoning, String time, String amPm) {
        this.dateTime = dateTime;
        this.emotionalState = emotionalState;
        this.location = location;
        this.reasoning = reasoning;
        this.time = time;
        this.amPm = amPm;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public Month getMonth() {
        return dateTime.getMonth();
    }

    public int getYear() {
        return dateTime.getYear();
    }

    public EmotionalState[] getEmotionalState() {
        return emotionalState;
    }

    public void setEmotionalState(EmotionalState[] emotionalState) {
        this.emotionalState = emotionalState;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReasoning() { return reasoning; }

    public void setReasoning(String reasoning) { this.reasoning = reasoning; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getAmPm() { return amPm; }

    public void setAmPm(String amPm) { this.amPm = amPm; }
}
