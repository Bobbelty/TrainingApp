package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
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
import com.example.trainingapp.model.ActiveWorkout;
import com.example.trainingapp.view.EditScheduleActivity;
import com.example.trainingapp.viewModel.HistoryViewModel;

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ListViewHolder>{

    private List<ActiveWorkout> completedWorkouts;
    private Context context;
    private ActiveWorkout selectedActiveWorkout;
    private HistoryViewModel historyViewModel = HistoryViewModel.getInstance();

    public HistoryRecyclerViewAdapter(List<ActiveWorkout> completedWorkouts, Context context) {
        this.completedWorkouts = completedWorkouts;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryRecyclerViewAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HistoryRecyclerViewAdapter.ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_history_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryRecyclerViewAdapter.ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.lblActiveWorkoutName.setText(plan.getWorkoutList().get(position).getName());
        holder.lblActiveWorkoutDate.setText(.getWorkoutList().get(position).getCurrentDate()))
        // set list views
        holder.btnExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                ExerciseHistoryRecyclerViewAdapter.setSelectedActiveWorkout(plan.getWorkoutList().get(position));

                Intent openActivity = new Intent(context, EditScheduleActivity.class);
                context.startActivity(openActivity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return selectedActiveWorkout.getExerciseList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView lblActiveWorkoutName;
        private final Button btnExercises;
        private final TextView lblActiveWorkoutDate;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblActiveWorkoutName= itemView.findViewById(R.id.lblActiveWorkoutName);
            btnExercises = itemView.findViewById(R.id.btnExercises);
            lblActiveWorkoutDate = itemView.findViewById(R.id.lblActiveWorkoutDate);



        }
    }

}
