package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.ActiveWorkout;

public class ExerciseHistoryRecyclerViewAdapter extends RecyclerView.Adapter<ExerciseHistoryRecyclerViewAdapter.ListViewHolder> {

    private ActiveWorkout selectedActiveWorkout;

    public ExerciseHistoryRecyclerViewAdapter(ActiveWorkout selectedActiveWorkout){
        this.selectedActiveWorkout = selectedActiveWorkout;
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
