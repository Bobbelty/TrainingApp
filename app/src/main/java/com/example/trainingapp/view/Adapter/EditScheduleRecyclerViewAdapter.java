package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.text.Editable;
import android.text.TextWatcher;
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
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.lblExercise.setText(selectedWorkout.getExerciseList().get(position).getName());
        holder.etbxNoOfSets.setText(selectedWorkout.getExerciseList().get(position).getNumberOfSets() + "");
        holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getNumberOfReps() + "");

        holder.etbxNoOfSets.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(holder.etbxNoOfSets.getText().equals("")) {
                    holder.etbxNoOfSets.setText(selectedWorkout.getExerciseList().get(position).getNumberOfSets() + "");
                }
                else {
                    selectedWorkout.getExerciseList().get(position).setNumberOfSets(Integer.parseInt(holder.etbxNoOfSets.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        holder.etbxNoOfReps.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(holder.etbxNoOfReps.getText().equals("")) {
                    holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getNumberOfReps() + "");
                }
                else {
                    selectedWorkout.getExerciseList().get(position).setNumberOfReps(Integer.parseInt(holder.etbxNoOfReps.getText().toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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
        private final EditText etbxNoOfReps;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblExercise = itemView.findViewById(R.id.lblExercise);
            etbxNoOfSets = itemView.findViewById(R.id.etbxNoOfSets);
            etbxNoOfReps = itemView.findViewById(R.id.etbxNoOfReps);

        }
    }
}