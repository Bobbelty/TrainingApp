package com.example.trainingapp.view;

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
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;
import com.example.trainingapp.view.Adapter.EditWorkoutRecyclerViewAdapter;
import com.example.trainingapp.view.Adapter.HistoryExercisesRecyclerViewAdapter;
import com.example.trainingapp.viewModel.EditWorkoutViewModel;
import com.example.trainingapp.viewModel.HistoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryExercisesFragment extends Fragment {

    private ActiveWorkout selectedWorkout;
    private HistoryExercisesRecyclerViewAdapter recyclerViewAdapter;
    private HistoryViewModel historyViewModel = HistoryViewModel.getInstance();
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

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_exercise_history,container,false);
        selectedWorkout = historyViewModel.getSelectedWorkout();
        initLabels(v);
        initRecyclerView(v);
        return v;
    }


    /**
     * initRecyclerView initiates the recyclerView and sets its adapter.
     *
     * @param v the current view used in the application.
     */
    private void initRecyclerView(View v) {
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.HistoryExerciseRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new HistoryExercisesRecyclerViewAdapter(selectedWorkout);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    /**
     * initTitleText initiates the title text label.
     *
     * @param v the current view used in the application
     */
    private void initLabels(View v) {
        TextView lblViewActiveWorkout = v.findViewById(R.id.lblViewActiveWorkout);
        lblViewActiveWorkout.setText(selectedWorkout.getName());
        TextView lblTopTextReps = v.findViewById(R.id.lblTopTextReps);
        lblTopTextReps.setText("Reps");
        TextView lblTopTextWeight = v.findViewById(R.id.lblTopTextWeight);
        lblTopTextWeight.setText("Weight");
    }
}
