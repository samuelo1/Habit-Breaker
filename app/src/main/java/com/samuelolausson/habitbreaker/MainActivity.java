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

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        populateCache();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
        Event.EmotionalState[] event1Emotions = {Event.EmotionalState.ANGRY, Event.EmotionalState.LONELY};
        Event event1 = new Event(3, "February", 2023, event1Emotions, "house", "retribution", "8:00", "PM");
        myCache.addFailureEvent(event1);
        // Relapse Event
        Event.EmotionalState[] event2Emotions = {Event.EmotionalState.ANGRY};
        Event event2 = new Event(9, "February", 2023, event2Emotions, "house", "I earned it", "8:30", "PM");
        myCache.addFailureEvent(event2);
        // Resist Event
        Event.EmotionalState[] event3Emotions = {Event.EmotionalState.HAPPY};
        Event event3 = new Event(12, "February", 2023, event2Emotions, "house", "Focused on my end goal", "7:30", "PM");
        myCache.addSuccessEvent(event3);
        // Resist Event
        Event.EmotionalState[] event4Emotions = {Event.EmotionalState.ANGRY};
        Event event4 = new Event(14, "February", 2023, event2Emotions, "house", "Left the house", "7:30", "PM");
        myCache.addSuccessEvent(event4);
    }
}