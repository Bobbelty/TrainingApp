package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.view.EditScheduleActivity;
import com.example.trainingapp.view.HistoryExercisesActivity;
import com.example.trainingapp.viewModel.HistoryViewModel;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ListViewHolder>{

    private List<ActiveWorkout> completedWorkouts;
    private Context context;
    private Activity activity;
    private HistoryViewModel historyViewModel = HistoryViewModel.getInstance();

    public HistoryRecyclerViewAdapter(List<ActiveWorkout> completedWorkouts, Activity activity, Context context) {
        this.completedWorkouts = completedWorkouts;
        this.activity = activity;
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
        holder.btnViewExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyViewModel.setSelectedWorkout(completedWorkouts.get(position));

                activity.onBackPressed();
                Intent openActivity = new Intent(context, HistoryExercisesActivity.class);
                context.startActivity(openActivity);
            }
        });


    }

    @Override
    public int getItemCount() { return completedWorkouts.size(); }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView lblActiveWorkoutName;
        private final TextView lblActiveWorkoutDate;
        private final Button btnViewExercises;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            lblActiveWorkoutName= itemView.findViewById(R.id.lblActiveWorkoutName);
            lblActiveWorkoutDate = itemView.findViewById(R.id.lblActiveWorkoutDate);
            btnViewExercises = itemView.findViewById(R.id.btnViewExercises);
        }
    }

}
