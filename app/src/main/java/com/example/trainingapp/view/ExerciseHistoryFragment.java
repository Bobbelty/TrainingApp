package com.example.trainingapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.ActiveWorkout;
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;
import com.example.trainingapp.view.Adapter.EditScheduleRecyclerViewAdapter;
import com.example.trainingapp.view.Adapter.ExerciseHistoryRecyclerViewAdapter;
import com.example.trainingapp.viewModel.EditScheduleViewModel;
import com.example.trainingapp.viewModel.ExerciseHistoryViewModel;
import com.example.trainingapp.viewModel.ScheduleViewModel;

import java.util.ArrayList;
import java.util.List;

public class ExerciseHistoryFragment extends Fragment {


    private ActiveWorkout selectedActiveWorkout;
    private ExerciseHistoryRecyclerViewAdapter recyclerViewAdapter;
    private ExerciseHistoryViewModel exerciseHistoryViewModel = ExerciseHistoryViewModel.getInstance();

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
        selectedActiveWorkout = exerciseHistoryViewModel.getSelectedWorkout();

        return v;
    }

    private void initRecyclerView(View v) {

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.exercise_history_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        recyclerViewAdapter = new ExerciseHistoryRecyclerViewAdapter(this.getActivity());
        recyclerView.setAdapter(recyclerViewAdapter);
    }

}
