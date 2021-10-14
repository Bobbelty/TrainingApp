package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.Workout;
import com.example.trainingapp.view.EditScheduleActivity;

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
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.lblExercise.setText(selectedWorkout.getExerciseList().get(position).getName());
        holder.etbxNoOfSets.setText(selectedWorkout.getExerciseList().get(position).getNumberOfSets() + "");
        holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getNumberOfReps() + "");

        holder.btnDeleteExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                selectedWorkout.getExerciseList().remove(position);
                notifyDataSetChanged();
            }
        });
        holder.etbxNoOfSets.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = holder.etbxNoOfSets.getText().toString();
                if(txt.equals("")) {
                    holder.etbxNoOfSets.setText(selectedWorkout.getExerciseList().get(position).getNumberOfSets() + "");
                }
                else {
                    selectedWorkout.getExerciseList().get(position).setNumberOfSets(Integer.parseInt(holder.etbxNoOfSets.getText().toString()));
                }
            }
        });
        holder.etbxNoOfReps.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = holder.etbxNoOfReps.getText().toString();
                if(txt.equals("")) {
                    holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getNumberOfSets() + "");
                }
                else {
                    selectedWorkout.getExerciseList().get(position).setNumberOfReps(Integer.parseInt(holder.etbxNoOfReps.getText().toString()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return selectedWorkout.getExerciseList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        //change name, make private maybe final
        private final TextView lblExercise;
        private final EditText etbxNoOfSets;
        private final EditText etbxNoOfReps;
        private final Button btnDeleteExercise;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblExercise = itemView.findViewById(R.id.lblExercise);
            etbxNoOfSets = itemView.findViewById(R.id.etbxNoOfSets);
            etbxNoOfReps = itemView.findViewById(R.id.etbxNoOfReps);
            btnDeleteExercise = itemView.findViewById(R.id.btnDeleteExercise);

        }
    }
}