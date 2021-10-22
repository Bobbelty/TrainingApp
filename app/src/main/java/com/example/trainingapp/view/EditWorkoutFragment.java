package com.example.trainingapp.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;
import com.example.trainingapp.view.Adapter.EditScheduleRecyclerViewAdapter;
import com.example.trainingapp.view.Adapter.EditWorkoutRecyclerViewAdapter;
import com.example.trainingapp.viewModel.EditWorkoutViewModel;

import java.util.ArrayList;
import java.util.List;

public class EditWorkoutFragment extends Fragment {

    //Plan activePlan;
    private Workout selectedWorkout;
    private EditWorkoutRecyclerViewAdapter recyclerViewAdapter;
    private EditWorkoutViewModel editWorkoutViewModel = EditWorkoutViewModel.getInstance();

    private List<Plan> testPlans = new ArrayList<>();

    Plan plan; // plan should be the first plan in the database (SavedPlans)
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

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_edit_activeworkout,container,false);
        initObjects();
        selectedWorkout = editWorkoutViewModel.getSelectedWorkout();
        initTitleText(v);
        initRecyclerView(v);
        initFinishWorkoutButton(v);
        return v;
    }
    private void initFinishWorkoutButton(View v) {
        Button btnAddExercise = v.findViewById(R.id.btnFinishWorkout);
        btnAddExercise.setVisibility(View.VISIBLE);
        btnAddExercise.setText("Finish workout");
        btnAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getActivity().getCurrentFocus() != null) getActivity().getCurrentFocus().clearFocus();
                initPopupMessageView(v);
            }
        });
    }
    private void initPopupMessageView(View v) {
        TextView alertTextView = (TextView) v.findViewById(R.id.alertTextViewEndActive);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setCancelable(true);
        builder.setTitle("Finish workout");
        builder.setMessage("Are you sure you want to end this workout?");

        builder.setNegativeButton("KEEP TRAINING", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("FINISH WORKOUT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                editWorkoutViewModel.endActiveWorkout();
                getActivity().finish();
                alertTextView.setVisibility(View.VISIBLE);
            }
        });
        builder.show();
    }

    /**
     * initRecyclerView initiates the recyclerView and sets its adapter.
     *
     * @param v the current view used in the application.
     */
    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.editScheduleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new EditWorkoutRecyclerViewAdapter(this.getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * initTitleText initiates the title text label.
     *
     * @param v the current view used in the application
     */
    private void initTitleText(View v) {
        TextView tbxWorkoutName = v.findViewById(R.id.tbxWorkoutName);
        tbxWorkoutName.setText(selectedWorkout.getName());
    }
    /**
     * initObjects gets the saved plans, used for testing and initial demo/presentation.
     */
    private void initObjects() {
        // setting up test objects
        testPlans = editWorkoutViewModel.getSavedPlans();
        plan = testPlans.get(0); // get active plan instead
    }
}
