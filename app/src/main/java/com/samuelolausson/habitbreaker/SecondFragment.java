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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;


import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;


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
        Button submitButton = view.findViewById(R.id.submit_button);


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

        submitButton.setOnClickListener(v -> {
            // Get the day month and year
            Date date = new Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            int monthInt = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            // Convert month int to string
            String month;
            switch (monthInt) {
                case 0:
                    month = "January";
                    break;
                case 1:
                    month = "February";
                    break;
                case 2:
                    month = "March";
                    break;
                case 3:
                    month = "April";
                    break;
                case 4:
                    month = "May";
                    break;
                case 5:
                    month = "June";
                    break;
                case 6:
                    month = "July";
                    break;
                case 7:
                    month = "August";
                    break;
                case 8:
                    month = "September";
                    break;
                case 9:
                    month = "October";
                    break;
                case 10:
                    month = "November";
                    break;
                default:
                    month = "December";
                    break;
            }


            // Get the location manager
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

            // Check if location services are enabled
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // Request permission to access location
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return;
            }

            // Get the last known location
            Location location2 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double latitude = location2.getLatitude();
            double longitude = location2.getLongitude();
            // Store the location

            // Get the text from the message text box
            String message = messageText.getText().toString();
            // Get the text from the time spinner
            String time = timeOfDay.getSelectedItem().toString();
            // Get the text from the AmPm spinner
            String amPmStr = amPm.getSelectedItem().toString();
            // Initialize array and list
            Event.EmotionalState[] emotionalStates = {};
            List<Event.EmotionalState> emotionsList = new ArrayList<>();
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
            //Toast.makeText(getContext(), "Latitude: " + latitude + ", Longitude: " + longitude, Toast.LENGTH_SHORT).show();
            Event newEvent = new Event(day, month, year, emotionalStates, message, time, amPmStr, latitude,longitude);

            if (resist.isChecked()) {
                myCache.addSuccessEvent(newEvent);
            }
            else if (relapse.isChecked()) {
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
            // return to first fragment
            NavHostFragment.findNavController(SecondFragment.this)
                    .navigate(R.id.action_SecondFragment_to_FirstFragment);
        });

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
            } else {
                // Permission denied
            }
        }
    }

}