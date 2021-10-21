package com.example.trainingapp.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.databinding.FragmentScheduleBinding;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.view.Adapter.ScheduleRecyclerViewAdapter;
import com.example.trainingapp.viewModel.ScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * ScheduleFragment acts as the "view" in mvvm. It is responsible for displaying all parts to the
 * fragment.schedule.xml
 *
 * @author Philip Rabia and Patrik Olsson
 */

public class ScheduleFragment extends Fragment {

    /**
     * Instance of ScheduleViewModel to enable communication and displaying of the correct elements.
     */

    private ScheduleViewModel scheduleViewModel = new ScheduleViewModel();
    private EditText etbxPlanName;
    private ArrayAdapter<Plan> adapter;
    private List<Plan> planList = new ArrayList<>();
    private Plan selectedPlan; // plan should be the first plan in the database (SavedPlans)
    private RecyclerView recyclerView;
    private ScheduleRecyclerViewAdapter recyclerViewAdapter;
    private Spinner dropdown;
    /**
     * Instance of the binding-class for fragment_schedule.xml. Allows for access of all the root views
     * ID's.
     */

    private FragmentScheduleBinding binding; //


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
        initAddWorkoutButton(v);
        initAddPlanButton(v);
        initRemovePlanButton(v);
        initPlanNameEditText(v);

        return v;
    }
    private void initAddPlanButton(View v) {
        Button btnAddPlan = v.findViewById(R.id.btnAddPlan);
        btnAddPlan.setText("+");

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Add plan
                scheduleViewModel.addPlan();
                planList = scheduleViewModel.getTrainingAppModel().getSavedPlans();
                scheduleViewModel.shiftRight(planList);
                selectedPlan = planList.get(0);

                // Update view
                adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, planList);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                dropdown.setAdapter(adapter);
            }
        });
    }
    private void initRemovePlanButton(View v) {
        Button btnRemovePlan = v.findViewById(R.id.btnRemovePlan);
        btnRemovePlan.setText("-");

        btnRemovePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(scheduleViewModel.getTrainingAppModel().getSavedPlans().size() <= 1)) {
                    popupMessage(v);
                }
            }
        });
    }
    private void popupMessage(View v) {
        TextView alertTextView = (TextView) v.findViewById(R.id.alertTextView);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setCancelable(true);
        builder.setTitle("Remove plan");
        builder.setMessage("Are you sure you want to remove this plan?");

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("REMOVE PLAN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                // Remove plan
                scheduleViewModel.removePlan(selectedPlan);
                planList = scheduleViewModel.getTrainingAppModel().getSavedPlans();
                selectedPlan = scheduleViewModel.getTrainingAppModel().getSavedPlans().get(0);

                // Update view
                adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, planList);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                dropdown.setAdapter(adapter);

            }
        });
        builder.show();
    }

    private void initPlanNameEditText(View v) {
        etbxPlanName = v.findViewById(R.id.etbxPlanName);
        etbxPlanName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = etbxPlanName.getText().toString();
                if(txt.equals("")) {
                    etbxPlanName.setText(selectedPlan.getPlanName());
                }
                else {
                    scheduleViewModel.setNewPlanName(selectedPlan, etbxPlanName, planList);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
    private void initAddWorkoutButton(View v) {
        Button btnAddWorkout = v.findViewById(R.id.btnAddWorkout);
        btnAddWorkout.setText("Add workout");

        btnAddWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scheduleViewModel.getTrainingAppModel().addWorkoutToPlan(selectedPlan.getId());

                selectedPlan = scheduleViewModel.getTrainingAppModel().getPlan(selectedPlan.getId());

                recyclerViewAdapter = new ScheduleRecyclerViewAdapter(selectedPlan, getContext(), getActivity());
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
    }

    /**
     * initRecyclerView initiates the recyclerView and sets its adapter.
     *
     * @param v the current view used in the application.
     */
    private void initRecyclerView(View v) {
        recyclerView = (RecyclerView) v.findViewById(R.id.schedule_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerViewAdapter = new ScheduleRecyclerViewAdapter(selectedPlan, this.getContext(), this.getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * initSpinner initiates the spinner, sets its adapter and its items
     *
     * @param v the current view used in the application.
     */
    private void initSpinner(View v) {

        dropdown = (Spinner) v.findViewById(R.id.schedule_spinner_dropdown);
        adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, planList);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                selectedPlan = planList.get(position);

                recyclerViewAdapter.setNewPlan(selectedPlan);
                etbxPlanName.setText(selectedPlan.getPlanName());
                selectedPlan = scheduleViewModel.getTrainingAppModel().getPlan(selectedPlan.getId());
                recyclerViewAdapter = new ScheduleRecyclerViewAdapter(selectedPlan, getContext(), getActivity());
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    /**
     * initObjects gets the saved plans, used for testing and initial demo/presentation.
     */
    //initiates test objects
    private void initObjects() {
        // setting up test objects
        planList = scheduleViewModel.getTrainingAppModel().getSavedPlans();
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