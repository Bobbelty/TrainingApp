package com.example.trainingapp.ui.schedule;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.trainingapp.R;
import com.example.trainingapp.databinding.FragmentScheduleBinding;

public class ScheduleFragment extends Fragment {

    private ScheduleViewModel scheduleViewModel;
    private FragmentScheduleBinding binding;
    private Spinner dropdown;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        scheduleViewModel =
                new ViewModelProvider(this).get(ScheduleViewModel.class);

        binding = FragmentScheduleBinding.inflate(inflater, container, false);

        // pretty cool stuff so it works
        View root = inflater.inflate(R.layout.activity_main, container, false);

        final TextView textView = binding.textSchedule;

        /*scheduleViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        dropdown = root.findViewById(R.id.spinner_dropdown);
        init_spinnerDropdown();
        return root;
    }

    // initiates items in dropdown menu based on users workout schedule
    private void init_spinnerDropdown() {
        String[] items = new String[]{"item1", "item2", "item3"};
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);

        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //System.out.println(adapterView.getItemAtPosition(position));
                //((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}