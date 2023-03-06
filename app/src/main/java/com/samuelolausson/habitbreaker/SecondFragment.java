package com.samuelolausson.habitbreaker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.samuelolausson.habitbreaker.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private CheckBox checkBoxHappy;
    private CheckBox checkBoxSad;
    private CheckBox checkBoxAngry;
    private CheckBox checkBoxDisappointed;
    private CheckBox checkBoxBored;
    private EditText messageText;
    private Button submitButton;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        checkBoxHappy = view.findViewById(R.id.checkbox_happy);
        checkBoxSad = view.findViewById(R.id.checkbox_sad);
        checkBoxAngry = view.findViewById(R.id.checkbox_angry);
        checkBoxDisappointed = view.findViewById(R.id.checkbox_disappointed);
        checkBoxBored = view.findViewById(R.id.checkbox_bored);
        messageText = view.findViewById(R.id.message_text);
        submitButton = view.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the message text box
                String message = messageText.getText().toString();

                // Process the checkbox selections
                if (checkBoxHappy.isChecked()) {
                    // Do something if happy is selected
                }
                if (checkBoxSad.isChecked()) {
                    // Do something if sad is selected
                }
                if (checkBoxAngry.isChecked()) {
                    // Do something if angry is selected
                }
                if (checkBoxDisappointed.isChecked()) {
                    // Do something if disappointed is selected
                }
                if (checkBoxBored.isChecked()) {
                    // Do something if bored is selected
                }
                //do something with the text box
                // Clear the checkboxes and message text box
                checkBoxHappy.setChecked(false);
                checkBoxSad.setChecked(false);
                checkBoxAngry.setChecked(false);
                checkBoxDisappointed.setChecked(false);
                checkBoxBored.setChecked(false);
                messageText.setText("");
            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}