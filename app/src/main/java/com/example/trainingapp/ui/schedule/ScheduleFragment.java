package com.example.trainingapp.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.databinding.FragmentScheduleBinding;
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    private ScheduleViewModel scheduleViewModel;

    // objects to test on
    private FragmentScheduleBinding binding;
    private List<Integer> testlistEx = new ArrayList<>();
    private List<Exercise> testlistWorkout = new ArrayList<>();
    private List<Workout> testList123 = new ArrayList<>();
    private List<Plan> testPlans = new ArrayList<>();
    Plan plan;

    String[] name = {"Hej1", "hej2", "Hej3"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        //View v = inflater.inflate(R.layout.fragment_schedule_recyclerview, container, false);
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_schedule,container,false);
        initObjects();

        initSpinner(v);
        initRecyclerView(v);

        return v;
    }
    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.schedule_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(plan));
    }
    private void initSpinner(View v) {

        Spinner dropdown = (Spinner) v.findViewById(R.id.schedule_spinner_dropdown);
        ArrayAdapter<Plan> adapter = new ArrayAdapter<Plan>(this.getActivity(), android.R.layout.simple_spinner_item, testPlans);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //System.out.println(testPlans.get(position).getWorkouts().get(0).getName()); works
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    //initiates test objects
    private void initObjects() {
        // setting up test objects
        testlistEx.add(1);
        System.out.print("Funkar hit");
        testlistEx.add(3);

        Exercise benchpress = new Exercise("benchpress", testlistEx);
        testlistWorkout.add(benchpress);

        Workout chestday = new Workout("chestday", testlistWorkout);
        testList123.add(chestday);

        Plan deff = new Plan("deff", testList123);
        testList123.add(chestday);
        Plan bulk = new Plan("bulk", testList123);

        testPlans.add(deff);
        testPlans.add(bulk);
        plan = bulk;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}