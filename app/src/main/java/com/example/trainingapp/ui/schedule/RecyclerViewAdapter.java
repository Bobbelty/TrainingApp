package com.example.trainingapp.ui.schedule;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.MainActivity;
import com.example.trainingapp.R;
import com.example.trainingapp.model.Plan;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder> {


    Plan plan;

    public RecyclerViewAdapter(Plan plan) {
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

        holder.lblWorkoutName.setText(plan.getWorkouts().get(position).getName());
        // set list views
    }
    @Override
    public int getItemCount() {
        return plan.getWorkouts().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        //change name, make private maybe final
        TextView lblWorkoutName;
        ListView lbxExercises;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblWorkoutName = itemView.findViewById(R.id.lblWorkoutName);
            lbxExercises = itemView.findViewById(R.id.lbxExercises);
        }
    }
}