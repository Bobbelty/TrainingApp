package com.example.trainingapp.view.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.view.EditScheduleActivity;
import com.example.trainingapp.model.Plan;

public class ScheduleRecyclerViewAdapter extends RecyclerView.Adapter<ScheduleRecyclerViewAdapter.ListViewHolder> {


    private Plan plan;
    private Context context;

    public ScheduleRecyclerViewAdapter(Plan plan, Context context) {
        this.plan = plan;
        this.context = context;
    }

    public void setNewPlan(Plan plan) {
        this.plan = plan;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_schedule_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        holder.lblWorkoutName.setText(plan.getWorkoutList().get(position).getName());
        // set list views
        holder.btnEditExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                // send over plan.getWorkouts().get(position) via TextActivity
                Intent openActivity = new Intent(context, EditScheduleActivity.class);
                context.startActivity(openActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plan.getWorkoutList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        //change name, make private maybe final
        private final TextView lblWorkoutName;
        private final ListView lbxExercises;
        private final Button btnEditExercise;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblWorkoutName = itemView.findViewById(R.id.lblWorkoutName);
            lbxExercises = itemView.findViewById(R.id.lbxExercises);
            btnEditExercise = itemView.findViewById(R.id.btnEditExercise);

        }
    }
}