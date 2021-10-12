package com.example.trainingapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
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
import com.example.trainingapp.view.Adapter.ScheduleRecyclerViewAdapter;
import com.example.trainingapp.viewModel.ScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * ScheduleFragment acts as the "view" in mvvm. It is responsible for displaying all parts to the
 * fragment.schedule.xml
 *
 * @author Valdemar Vålvik and Victor Hui
 */

public class ScheduleFragment extends Fragment {

    /**
     * Instance of ScheduleViewModel to enable communication and displaying of the correct elements.
     */

    private ScheduleViewModel scheduleViewModel = new ScheduleViewModel(); // could possibly delete this

    /**
     * Instance of the binding-class for fragment_schedule.xml. Allows for access of all the root views
     * ID's.
     */

    private FragmentScheduleBinding binding; //

    // objects to test on

    private List<Plan> testPlans = new ArrayList<>();

    Plan plan; // plan should be the first plan in the database (SavedPlans)
    ScheduleRecyclerViewAdapter recyclerViewAdapter;


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
        //FrameLayout fl = (FrameLayout) v.findViewById(R.id.fragment_container);
        recyclerViewAdapter = new ScheduleRecyclerViewAdapter(plan, this.getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    private void initSpinner(View v) {

        Spinner dropdown = (Spinner) v.findViewById(R.id.schedule_spinner_dropdown);
        ArrayAdapter<Plan> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, testPlans);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                plan = testPlans.get(position);

                // sets new plan and notifies the adapter of the change
                recyclerViewAdapter.setNewPlan(plan);
                //user.setActivePlan(plan);
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    //initiates test objects
    private void initObjects() {
        // setting up test objects

        testPlans = scheduleViewModel.getTrainingAppModel().getSavedPlans();
        plan = testPlans.get(0);

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