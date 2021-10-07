package com.example.trainingapp.view.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Workout;

public class EditScheduleRecyclerViewAdapter extends RecyclerView.Adapter<EditScheduleRecyclerViewAdapter.ListViewHolder> {


    private Workout selectedWorkout;

    public EditScheduleRecyclerViewAdapter(Workout selectedWorkout) {
        this.selectedWorkout = selectedWorkout;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_edit_schedule_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {

        holder.lblExercise.setText("Övning 1");
        holder.etbxNoOfSets.setText("5");
        holder.etbxReps.setText("10");

        // Either savebutton to save data to database or event from edit text boxes
    }

    @Override
    public int getItemCount() {
        return selectedWorkout.getExerciseList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        //change name, make private maybe final
        private final TextView lblExercise;
        private final EditText etbxNoOfSets;
        private final EditText etbxReps;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblExercise = itemView.findViewById(R.id.lblExercise);
            etbxNoOfSets = itemView.findViewById(R.id.etbxNoOfSets);
            etbxReps = itemView.findViewById(R.id.etbxReps);

        }
    }
}