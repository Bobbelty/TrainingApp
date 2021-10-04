package com.example.trainingapp.ui.schedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
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
    private List<Integer> listOfSetsLegpress = new ArrayList<>();
    private Exercise legpress;
    private List<Exercise> listOfExercisesLegday = new ArrayList<>();
    private Workout legday;
    private List<Workout> listOfWorkoutsLegday = new ArrayList<>();

    private List<Integer> listOfSetsBench = new ArrayList<>();
    private Exercise benchpress;
    private List<Exercise> listOfExercisesChestday = new ArrayList<>();
    private Workout chestday;
    private List<Workout> listOfWorkoutsChestday = new ArrayList<>();


    private List<Plan> testPlans = new ArrayList<>();

    Plan plan; // plan should be the first plan in the database (SavedPlans)
    RecyclerViewAdapter recyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_schedule,container,false);

        initObjects();

        initRecyclerView(v);
        initSpinner(v);

        return v;
    }

    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.schedule_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAdapter = new RecyclerViewAdapter(plan);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    private void initSpinner(View v) {

        Spinner dropdown = (Spinner) v.findViewById(R.id.schedule_spinner_dropdown);
        ArrayAdapter<Plan> adapter = new ArrayAdapter<Plan>(this.getActivity(), android.R.layout.simple_spinner_item, testPlans);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                plan = testPlans.get(position);

                // sets new plan and notifies the adapter of the change
                recyclerViewAdapter.setNewPlan(plan);
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    //initiates test objects
    private void initObjects() {
        /*private FragmentScheduleBinding binding;
        private List<Integer> listOfSetsLegpress = new ArrayList<>();
        private List<Exercise> listOfExercisesLegday = new ArrayList<>();
        private List<Workout> listOfWorkoutsLegday = new ArrayList<>();

        private List<Integer> listOfSetsBench = new ArrayList<>();
        private List<Exercise> listOfExercisesChestday = new ArrayList<>();
        private List<Workout> listOfWorkoutsChestday = new ArrayList<>();*/
        // setting up test objects
        listOfSetsLegpress.add(5); // 5 reps 1 time
        listOfSetsBench.add(3); // 3 reps 1 time

        legpress = new Exercise("legpress", listOfSetsLegpress);
        benchpress = new Exercise("benchpress", listOfSetsBench);

        listOfExercisesLegday.add(legpress);
        listOfExercisesChestday.add(benchpress);

        legday = new Workout("legday", listOfExercisesLegday);
        chestday = new Workout("chestday", listOfExercisesChestday);

        listOfWorkoutsLegday.add(legday);
        listOfWorkoutsLegday.add(chestday);

        listOfWorkoutsChestday.add(chestday);
        listOfWorkoutsChestday.add(legday);

        Plan plan1 = new Plan("summer workout", listOfWorkoutsLegday);
        Plan plan2 = new Plan("winter workout", listOfWorkoutsChestday);

        testPlans.add(plan1);
        testPlans.add(plan2);
        plan = plan1;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}