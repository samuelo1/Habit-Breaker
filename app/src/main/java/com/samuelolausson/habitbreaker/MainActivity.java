package com.samuelolausson.habitbreaker;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.samuelolausson.habitbreaker.Cache.Cache;
import com.samuelolausson.habitbreaker.Cache.Event;
import com.samuelolausson.habitbreaker.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateCache();

        com.samuelolausson.habitbreaker.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void populateCache() {
        Cache myCache = Cache.getCacheInstance();
        // Relapse Event
        for(int i = 0; i < 4; i++) {
            Event.EmotionalState[] event1Emotions = {Event.EmotionalState.ANGRY, Event.EmotionalState.LONELY};
            Event event1 = new Event(LocalDateTime.now().minusDays(3), event1Emotions, "house", "retribution", "8:00", "PM");
            myCache.addFailureEvent(event1);
        }

        // Relapse Event
        for(int i = 0; i < 2; i++) {
            Event.EmotionalState[] event1Emotions = {Event.EmotionalState.ANGRY, Event.EmotionalState.LONELY};
            Event event1 = new Event(LocalDateTime.now().minusDays(4), event1Emotions, "house", "retribution", "8:00", "PM");
            myCache.addFailureEvent(event1);
        }

        // Relapse Event
        for(int i = 0; i < 2; i++) {
            Event.EmotionalState[] event1Emotions = {Event.EmotionalState.ANGRY, Event.EmotionalState.LONELY};
            Event event1 = new Event(LocalDateTime.now().minusDays(2), event1Emotions, "house", "retribution", "8:00", "PM");
            myCache.addFailureEvent(event1);
        }

        Event.EmotionalState[] event2Emotions = {Event.EmotionalState.ANGRY};
        Event event2 = new Event(LocalDateTime.now().minusDays(1), event2Emotions, "house", "I earned it", "8:30", "PM");
        myCache.addFailureEvent(event2);

        // Resist Event
        Event.EmotionalState[] event3Emotions = {Event.EmotionalState.HAPPY};
        Event event3 = new Event(LocalDateTime.now(), event3Emotions, "house", "Focused on my end goal", "7:30", "PM");
        myCache.addSuccessEvent(event3);
        // Resist Event
        Event.EmotionalState[] event4Emotions = {Event.EmotionalState.ANGRY};
        Event event4 = new Event(LocalDateTime.now(), event4Emotions, "house", "Left the house", "7:30", "PM");
        myCache.addSuccessEvent(event4);
    }
}