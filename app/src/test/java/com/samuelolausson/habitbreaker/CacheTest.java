package com.samuelolausson.habitbreaker;

import com.samuelolausson.habitbreaker.Cache.Cache;
import com.samuelolausson.habitbreaker.Cache.Habit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CacheTest {

    Cache cache;

    @BeforeEach
    public void setup() {
        cache = Cache.getCacheInstance();
        cache.clearCache();
    }

    @Test
    public void singletonTest() {
        Assertions.assertEquals(0, Cache.getCacheInstance().getHabits().size());
        cache.addHabit(new Habit("Test_Name", new Date()));
        Assertions.assertEquals(1, Cache.getCacheInstance().getHabits().size());
    }
}
