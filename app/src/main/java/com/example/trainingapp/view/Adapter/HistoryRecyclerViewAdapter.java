package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.ActiveWorkout;
import com.example.trainingapp.view.EditScheduleActivity;
import com.example.trainingapp.view.ExerciseHistoryActivity;
import com.example.trainingapp.viewModel.ExerciseHistoryViewModel;
import com.example.trainingapp.viewModel.HistoryViewModel;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ListViewHolder>{

    private List<ActiveWorkout> completedWorkouts;
    private Context context;
    private ActiveWorkout selectedActiveWorkout;
    private ExerciseHistoryViewModel exerciseHistoryViewModel = ExerciseHistoryViewModel.getInstance();

    public HistoryRecyclerViewAdapter(List<ActiveWorkout> completedWorkouts, Context context) {
        this.completedWorkouts = completedWorkouts;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HistoryRecyclerViewAdapter.ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_history_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.lblActiveWorkoutName.setText(completedWorkouts.get(position).getName());
        holder.lblActiveWorkoutDate.setText(completedWorkouts.get(position).getTime());
        // set list views
    }

    @Override
    public int getItemCount() { return completedWorkouts.size(); }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView lblActiveWorkoutName;
        private final TextView lblActiveWorkoutDate;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            lblActiveWorkoutName= itemView.findViewById(R.id.lblActiveWorkoutName);
            lblActiveWorkoutDate = itemView.findViewById(R.id.lblActiveWorkoutDate);
        }
    }

}
