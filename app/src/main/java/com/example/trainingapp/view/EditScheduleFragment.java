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
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;
import com.example.trainingapp.view.Adapter.EditScheduleRecyclerViewAdapter;
import com.example.trainingapp.viewModel.EditScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

public class EditScheduleFragment extends Fragment {

    //Plan activePlan;
    private Workout selectedWorkout;
    private EditScheduleRecyclerViewAdapter recyclerViewAdapter;
    private EditScheduleViewModel editScheduleViewModel = EditScheduleViewModel.getInstance();

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

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_edit_schedule,container,false);
        // activePlan = user.getActivePlan();
        initObjects();
        selectedWorkout = editScheduleViewModel.getSelectedWorkout();
        initTitleText(v);
        initRecyclerView(v);
        initDeleteWorkoutButton(v);
        initAddExerciseButton(v);
        return v;
    }
    private void initAddExerciseButton(View v) {
        Button btnAddExercise = v.findViewById(R.id.btnAddExercise);
        btnAddExercise.setVisibility(View.VISIBLE);
        btnAddExercise.setText("Add exercise");
        btnAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditScheduleViewModel.getInstance().getTrainingAppModel().addExerciseToWorkout(selectedWorkout, "New exercise");
                // Make sure model adds a new exercise that the user later on can change in the UI
                // Benchpress  4  6
                // Exercise1  0  0
                // Exercise2  0  0
                //String name = "BenchPress";
                //name.toLowerCase(Locale.ROOT).replace(" ", "").replace("_","");

                // plocka från savedExercises

                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
    }
    private void initDeleteWorkoutButton(View v) {
        Button btnDeleteWorkout = v.findViewById(R.id.btnDeleteWorkout);
        btnDeleteWorkout.setVisibility(View.VISIBLE);
        btnDeleteWorkout.setText("Delete workout");
        btnDeleteWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPopupMessageView(v);
            }
        });
    }
    private void initPopupMessageView(View v) {
        TextView alertTextView = (TextView) v.findViewById(R.id.AlertTextView);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setCancelable(true);
        builder.setTitle("Remove workout");
        builder.setMessage("Are you sure you want to remove this workout?");

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("REMOVE WORKOUT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditScheduleViewModel.getInstance().removeWorkout(editScheduleViewModel.getSelectedPlan(), selectedWorkout);
                getActivity().finish();
                alertTextView.setVisibility(View.VISIBLE);
            }
        });
        builder.show();
    }
    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.editScheduleRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new EditScheduleRecyclerViewAdapter(this.getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void initTitleText(View v) {
        EditText etbxWorkoutName = v.findViewById(R.id.etbxWorkoutName);
        etbxWorkoutName.setText(selectedWorkout.getName());

        etbxWorkoutName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = etbxWorkoutName.getText().toString();
                if(txt.equals("")) {
                    etbxWorkoutName.setText(selectedWorkout.getName() + "");
                }
                else {
                    EditScheduleViewModel.getInstance().setNewWorkoutName(etbxWorkoutName);
                    //EditScheduleViewModel.getInstance().
                            //setNewExerciseName(position, etbxWorkoutName);
                }
            }
        });
    }
    private void initObjects() {
        // setting up test objects
        testPlans = editScheduleViewModel.getTrainingAppModel().getSavedPlans();
        plan = testPlans.get(0); // get active plan instead
    }
}
