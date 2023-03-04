package com.samuelolausson.habitbreaker;

import com.samuelolausson.habitbreaker.Cache.Cache;
import com.samuelolausson.habitbreaker.Cache.Habit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        cache.addHabit(new Habit());
        Assertions.assertEquals(1, Cache.getCacheInstance().getHabits().size());
    }
}
