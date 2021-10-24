package com.example.trainingapp.view.Workout.ActiveWorkout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.components.Workout;
import com.example.trainingapp.viewModel.EditWorkoutViewModel;

/**
 * Fragment for editing workouts during an active session
 */
public class EditWorkoutFragment extends Fragment {

    private Workout selectedWorkout;
    private EditWorkoutRecyclerViewAdapter recyclerViewAdapter;
    private EditWorkoutViewModel editWorkoutViewModel = EditWorkoutViewModel.getInstance();
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
        selectedWorkout = editWorkoutViewModel.getSelectedWorkout();
        initLabels(v);
        initRecyclerView(v);
        initFinishWorkoutButton(v);
        return v;
    }

    /**
     * initFinishWorkoutButton initiates the 'finish workout'-button
     *
     * @param v the current view used in the application
     */
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

    /**
     * initPopupMessageView initiates the popup message view.
     *
     * @param v the current view used in the application
     */
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
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.HistoryExerciseRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new EditWorkoutRecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * initTitleText initiates the title text label.
     *
     * @param v the current view used in the application
     */
    private void initLabels(View v) {
        TextView tbxWorkoutName = v.findViewById(R.id.tbxWorkoutName);
        tbxWorkoutName.setText(selectedWorkout.getName());
        TextView lblReps = v.findViewById(R.id.lblReps);
        lblReps.setText("Reps");
        TextView lblWeight = v.findViewById(R.id.lblWeight);
        lblWeight.setText("Weight");
    }
}
