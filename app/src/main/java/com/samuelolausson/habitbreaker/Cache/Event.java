package com.samuelolausson.habitbreaker.Cache;

import java.util.Date;

public class Event {

    public enum EmotionalState {
        HAPPY,
        SAD,
        ANGRY,
        DISAPPOINTED,
        BORED,
        LONELY,
    }

    int day;
    String month;
    int year;
    EmotionalState[] emotionalState;
    String location;
    String reasoning;

    String time;
    String amPm;

    public Event(int day, String month, int year, EmotionalState[] emotionalState, String location, String reasoning, String time, String amPm) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.emotionalState = emotionalState;
        this.location = location;
        this.reasoning = reasoning;
        this.time = time;
        this.amPm = amPm;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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
