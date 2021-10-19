package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.ActiveWorkout;
import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.viewModel.ExerciseHistoryViewModel;

public class ExerciseHistoryRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseHistoryRecyclerViewAdapter.ListViewHolder> {

    private ActiveWorkout selectedActiveWorkout;
    private Activity activity;
    private ExerciseHistoryViewModel exerciseHistoryViewModel = ExerciseHistoryViewModel.getInstance();

    public ExerciseHistoryRecyclerViewAdapter(Activity activity){
        this.activity = activity;
        this.selectedActiveWorkout = exerciseHistoryViewModel.getSelectedWorkout();
    }

    @NonNull
    @Override
    public ExerciseHistoryRecyclerViewAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_exercise_history_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseHistoryRecyclerViewAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.lblExerciseName.setText(selectedActiveWorkout.getExerciseList().get(position).getName());
    }

    @Override
    public int getItemCount() { return selectedActiveWorkout.getExerciseList().size(); }


    static class ListViewHolder extends RecyclerView.ViewHolder{


        private final TextView lblExerciseName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblExerciseName = itemView.findViewById(R.id.lblExerciseName);
        }
    }

}
