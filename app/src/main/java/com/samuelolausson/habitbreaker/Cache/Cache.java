package com.samuelolausson.habitbreaker.Cache;

import java.util.HashSet;
import java.util.Set;

public class Cache {

    static Cache cache;

    private Cache() {}

    public static Cache getCacheInstance() {
        if(cache == null) {
            cache = new Cache();
        }
        return cache;
    }

    private final Set<Habit> habits = new HashSet<>();
    private final Set<Event> successEvents = new HashSet<>();
    private final Set<Event> failureEvents = new HashSet<>();

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

    public Set<Habit> getHabits() {
        return habits;
    }

    public void addSuccessEvent(Event successEvent) {
        successEvents.add(successEvent);
    }

    public Set<Event> getSuccessEvents() {
        return successEvents;
    }

    public void addFailureEvent(Event failureEvent) {
        failureEvents.add(failureEvent);
    }

    public Set<Event> getFailureEvents() {
        return failureEvents;
    }

    public void clearCache() {
        habits.clear();
        successEvents.clear();
        failureEvents.clear();
    }
}
