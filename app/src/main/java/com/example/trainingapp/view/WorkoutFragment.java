package com.example.trainingapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.databinding.FragmentWorkoutBinding;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.view.Adapter.WorkoutRecyclerViewAdapter;
import com.example.trainingapp.viewModel.ScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * WorkoutFragment acts as the "view" in mvvm. It is responsible for displaying all parts to the
 * fragment.workout.xml
 *
 * @author Philip Rabia and Patrik Olsson
 */

public class WorkoutFragment extends Fragment {

    /**
     * Instance of WorkoutViewModel to enable communication and displaying of the correct elements.
     */

    private ScheduleViewModel scheduleViewModel = new ScheduleViewModel();
    private List<Plan> planList = new ArrayList<>();
    private ArrayAdapter<Plan> adapter;
    private Plan selectedPlan;
    private RecyclerView recyclerView;
    private WorkoutRecyclerViewAdapter recyclerViewAdapter;
    private Spinner dropdown;

    /**
     * Instance of the binding-class for fragment_workout.xml. Allows for access of all the root views
     * ID's.
     */

    private FragmentWorkoutBinding binding;

    /**
     * onCreateView creates and returns the view hierarchy associated with the fragment.
     *
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to.
     * The fragment should not add the view itself, but this can be used to generate the LayoutParams of the view.
     * This value may be null.
     * @param savedInstanceState  If non-null, this fragment is being re-constructed from a previous saved state as given here.
     *
     * @return Return the View for the fragment's UI, or null.
     */

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_workout,container,false);

        initObjects();
        initRecyclerView(v);
        initSpinner(v);

        return v;
    }

    private void initRecyclerView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.workoutRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAdapter = new WorkoutRecyclerViewAdapter(selectedPlan, this.getContext(), this.getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * initSpinner initiates the spinner, sets its adapter and its items
     *
     * @param v the current view used in the application.
     */
    private void initSpinner(View v) {

        dropdown = (Spinner) v.findViewById(R.id.workoutSpinner);
        adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, planList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                selectedPlan = planList.get(position);

                recyclerViewAdapter.setNewPlan(selectedPlan);
                selectedPlan = scheduleViewModel.getTrainingAppModel().getPlan(selectedPlan.getId());
                recyclerViewAdapter = new WorkoutRecyclerViewAdapter(selectedPlan, getContext(), getActivity());
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void initObjects() {
        planList = scheduleViewModel.getSavedPlans();
        selectedPlan = planList.get(0);
    }
    /**
     * onDestroyView is called when the view previously created by onCreateView has been detached from the fragment.
     * The next time the fragment needs to be displayed, a new view will be created.
     */

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}