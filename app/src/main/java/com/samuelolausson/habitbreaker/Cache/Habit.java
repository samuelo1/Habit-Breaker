package com.samuelolausson.habitbreaker.Cache;

import java.util.Date;

public class Habit {
    private String name;
    private Date startReform;

    public Habit(String name, Date date) {
        this.name = name;
        this.startReform = date;
    }
}
