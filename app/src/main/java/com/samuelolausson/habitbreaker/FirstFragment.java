package com.samuelolausson.habitbreaker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.samuelolausson.habitbreaker.Cache.Cache;
import com.samuelolausson.habitbreaker.Cache.Event;
import com.samuelolausson.habitbreaker.databinding.FragmentFirstBinding;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private final Cache cache = Cache.getCacheInstance();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        BarChart chart = binding.chart;
        chart.setData(getDayOfWeekData(cache.getFailureEvents()));

        ValueFormatter xAxisFormatter = new DayAxisValueFormatter();
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);
        xAxis.setValueFormatter(xAxisFormatter);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setGranularity(1f);
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setEnabled(false);

        Description description = new Description();
        description.setText("");
        chart.setDescription(description);

        chart.invalidate(); // refresh

        return binding.getRoot();

    }

    public static class DayAxisValueFormatter extends ValueFormatter {

        @Override
        public String getFormattedValue(float value) {
            if (value == 1.0) {
                return "Mon";
            }
            else if(value == 2.0) {
                return "Tue";
            }
            else if(value == 3.0) {
                return "Wed";
            }
            else if(value == 4.0) {
                return "Thur";
            }
            else if(value == 5.0) {
                return "Fri";
            }
            else if(value == 6.0) {
                return "Sat";
            }
            else {
                return "Sun";
            }
        }
    }

    private <T extends Event> BarData getDayOfWeekData(Set<T> events) {
        List<BarEntry> entries = new ArrayList<>();

        Map<Integer, Integer> counts = new HashMap<>();

        for (T event : events) {
            int eventKey = event.getDateTime().getDayOfWeek().getValue();
            if(!counts.containsKey(eventKey)) {
                counts.put(eventKey, 1);
            } else {
                counts.put(eventKey, counts.get(eventKey) + 1);
            }
            // turn your data into Entry objects
            entries.add(new BarEntry(event.getDateTime().getDayOfWeek().getValue(), counts.get(eventKey)));
        }

        BarDataSet dataSet = new BarDataSet(entries, ""); // add entries to dataset
        dataSet.setDrawValues(false);
        return new BarData(dataSet);
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}