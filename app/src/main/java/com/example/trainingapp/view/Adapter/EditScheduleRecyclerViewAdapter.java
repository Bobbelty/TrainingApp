package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;
import com.example.trainingapp.viewModel.EditWorkoutViewModel;

/**
 * Adapter for the RecyclerView in the EditScheduleActivity, provides the correct information for
 * each list item
 */
public class EditScheduleRecyclerViewAdapter extends RecyclerView.Adapter<EditScheduleRecyclerViewAdapter.ListViewHolder> {


    private Workout selectedWorkout;
    private Plan selectedPlan;
    private EditWorkoutViewModel editWorkoutViewModel = EditWorkoutViewModel.getInstance();

    /**
     * Constructor for adapter
     */
    public EditScheduleRecyclerViewAdapter() {
        this.selectedWorkout = editWorkoutViewModel.getSelectedWorkout();
        this.selectedPlan = editWorkoutViewModel.getSelectedPlan();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_edit_schedule_list_item, parent, false));
    }

    /**
     * Binds application data to the ViewHolder
     *
     * @param holder the ViewHolder
     * @param position current position in the exerciseList
     */
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.etbxExerciseName.setText(selectedWorkout.getExerciseList().get(position).getName());
        holder.etbxNoOfSets.setText(selectedWorkout.getExerciseList().get(position).getNumberOfSets() + "");
        holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getNumberOfReps() + "");

        holder.btnDeleteExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                editWorkoutViewModel.onClickRemoveExercise(
                        selectedPlan.getId(), selectedWorkout.getId(), selectedWorkout.getExerciseList().get(position).getId());
                selectedWorkout = editWorkoutViewModel.getWorkoutById(selectedPlan.getId(), selectedWorkout.getId());
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
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
                    editWorkoutViewModel.setNewNoOfSets(
                            Integer.parseInt(txt),
                            selectedPlan.getId(),
                            selectedWorkout.getId(),
                            selectedWorkout.getExerciseByIndex(position).getId());
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
                    editWorkoutViewModel.setNewNoOfReps(
                            Integer.parseInt(txt),
                            selectedPlan.getId(),
                            selectedWorkout.getId(),
                            selectedWorkout.getExerciseByIndex(position).getId());
                }
            }
        });
        holder.etbxExerciseName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = holder.etbxExerciseName.getText().toString();
                if(txt.equals("")) {
                    holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getName() + "");
                }
                else {
                    editWorkoutViewModel.setNewExerciseName(
                            holder.etbxExerciseName.getText().toString(),
                            selectedPlan.getId(), selectedWorkout.getId(),
                            selectedWorkout.getExerciseByIndex(position).getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return selectedWorkout.getExerciseList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final EditText etbxExerciseName;
        private final EditText etbxNoOfSets;
        private final EditText etbxNoOfReps;
        private final Button btnDeleteExercise;

        /**
         * Binds elements in layout file to the variables in the ViewHolder
         *
         * @param itemView the itemView
         */
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            etbxExerciseName = itemView.findViewById(R.id.etbxExerciseName);
            etbxNoOfSets = itemView.findViewById(R.id.etbxNoOfReps);
            etbxNoOfReps = itemView.findViewById(R.id.etbxWeight);
            btnDeleteExercise = itemView.findViewById(R.id.btnDeleteExercise);

        }
    }
}