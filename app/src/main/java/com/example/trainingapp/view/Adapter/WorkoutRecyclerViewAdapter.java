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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.view.EditWorkoutActivity;
import com.example.trainingapp.viewModel.EditWorkoutViewModel;

public class WorkoutRecyclerViewAdapter extends RecyclerView.Adapter<WorkoutRecyclerViewAdapter.ListViewHolder>  {


    private Plan plan;
    private Context context;
    private Activity activity;
    private EditWorkoutViewModel editWorkoutViewModel = EditWorkoutViewModel.getInstance();

    public WorkoutRecyclerViewAdapter(Plan plan, Context context, Activity activity) {
        this.plan = plan;
        this.context = context;
        this.activity = activity;
    }

    public void setNewPlan(Plan plan) { this.plan = plan; }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_workout_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.lblWorkoutName.setText(plan.getWorkoutList().get(position).getName());
        // set list views
        holder.btnWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                editWorkoutViewModel.setSelectedWorkout(plan.getWorkoutList().get(position));
                editWorkoutViewModel.setSelectedPlan(plan);

                activity.onBackPressed();
                Intent openActivity = new Intent(context, EditWorkoutActivity.class);
                context.startActivity(openActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plan.getWorkoutList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView lblWorkoutName;
        private final Button btnWorkout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblWorkoutName = itemView.findViewById(R.id.lblWorkoutName);
            btnWorkout = itemView.findViewById(R.id.btnWorkout);

        }
    }
}