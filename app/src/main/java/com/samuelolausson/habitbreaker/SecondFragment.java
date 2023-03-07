package com.samuelolausson.habitbreaker;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.samuelolausson.habitbreaker.Cache.Cache;
import com.samuelolausson.habitbreaker.Cache.Event;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SecondFragment extends Fragment {

    private RadioButton resist;
    private RadioButton relapse;
    private View view;
    private CheckBox checkBoxHappy;
    private CheckBox checkBoxSad;
    private CheckBox checkBoxAngry;
    private CheckBox checkBoxDisappointed;
    private CheckBox checkBoxBored;
    private CheckBox checkBoxLonely;
    private EditText messageText;
    private Spinner timeOfDay;
    private Spinner amPm;
    private EditText locationText;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Cache myCache = Cache.getCacheInstance();

        view = inflater.inflate(R.layout.fragment_second, container, false);

        resist = view.findViewById(R.id.resistRadio);
        relapse = view.findViewById(R.id.relapseRadio);
        checkBoxHappy = view.findViewById(R.id.checkbox_happy);
        checkBoxSad = view.findViewById(R.id.checkbox_sad);
        checkBoxAngry = view.findViewById(R.id.checkbox_angry);
        checkBoxDisappointed = view.findViewById(R.id.checkbox_disappointed);
        checkBoxBored = view.findViewById(R.id.checkbox_bored);
        checkBoxLonely = view.findViewById(R.id.checkbox_lonely);
        messageText = view.findViewById(R.id.message_text);
        timeOfDay = view.findViewById(R.id.timeSpinner);
        amPm = view.findViewById(R.id.amPmSpinner);
        locationText = view.findViewById(R.id.location_text);
        Button submitButton = view.findViewById(R.id.submit_button);
        //previous = view.findViewById(R.id.button_second);

        ArrayAdapter<CharSequence> adapterTime = ArrayAdapter.createFromResource(this.getContext(), R.array.time_of_day, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        timeOfDay.setAdapter(adapterTime);

        ArrayAdapter<CharSequence> adapterAmPm = ArrayAdapter.createFromResource(this.getContext(), R.array.am_pm, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterAmPm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        amPm.setAdapter(adapterAmPm);

//        previous.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//                NavHostFragment.findNavController(SecondFragment.this)
//                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
//            }
//        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the day month and year
                Date date = new Date();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                LocalDateTime dateTime = LocalDateTime.now();

                // Get the text from the message text box
                String message = messageText.getText().toString();
                // Get the text from the location text box
                String location = locationText.getText().toString();
                // Get the text from the time spinner
                String time = timeOfDay.getSelectedItem().toString();
                // Get the text from the AmPm spinner
                String amPmStr = amPm.getSelectedItem().toString();
                // Initialize array and list
                Event.EmotionalState[] emotionalStates = {};
                List<Event.EmotionalState> emotionsList = new ArrayList<Event.EmotionalState>();
                // Determine if this recording is for resist or relapse
                // Process the checkbox selections
                if (checkBoxHappy.isChecked()) {
                    emotionsList.add(Event.EmotionalState.HAPPY);
                }
                if (checkBoxSad.isChecked()) {
                    emotionsList.add(Event.EmotionalState.SAD);
                }
                if (checkBoxAngry.isChecked()) {
                    emotionsList.add(Event.EmotionalState.ANGRY);
                }
                if (checkBoxDisappointed.isChecked()) {
                    emotionsList.add(Event.EmotionalState.DISAPPOINTED);
                }
                if (checkBoxBored.isChecked()) {
                    emotionsList.add(Event.EmotionalState.BORED);
                }
                if (checkBoxLonely.isChecked()) {
                    emotionsList.add(Event.EmotionalState.LONELY);
                }
                // Convert list to our array
                emotionalStates = emotionsList.toArray(emotionalStates);
                Event newEvent = new Event(dateTime, emotionalStates, location, message, time, amPmStr);

                if (resist.isChecked()) {
                    myCache.addSuccessEvent(newEvent);
                } else if (relapse.isChecked()) {
                    myCache.addFailureEvent(newEvent);
                }

                // Clear the checkboxes and message text box
                resist.setChecked(false);
                relapse.setChecked(false);
                checkBoxHappy.setChecked(false);
                checkBoxSad.setChecked(false);
                checkBoxAngry.setChecked(false);
                checkBoxDisappointed.setChecked(false);
                checkBoxBored.setChecked(false);
                checkBoxLonely.setChecked(false);
                messageText.setText("");
                locationText.setText("");
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

}