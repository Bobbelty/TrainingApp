package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;
import com.example.trainingapp.viewModel.EditWorkoutViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for the RecyclerView in the EditWorkoutActivity, provides the correct information for
 * each list item
 */
public class EditWorkoutRecyclerViewAdapter extends RecyclerView.Adapter<EditWorkoutRecyclerViewAdapter.ListViewHolder> {


    private Activity activity;
    private Plan selectedPlan;
    private EditWorkoutViewModel editWorkoutViewModel = EditWorkoutViewModel.getInstance();
    private Workout selectedWorkout;
    private ActiveWorkout activeWorkout;

    /**
     * Constructor for adapter
     *
     * @param activity the current activity
     */
    public EditWorkoutRecyclerViewAdapter(Activity activity) {
        this.selectedWorkout = editWorkoutViewModel.getSelectedWorkout();
        this.activity = activity;
        this.selectedPlan = editWorkoutViewModel.getSelectedPlan();
        editWorkoutViewModel.createActiveWorkout(selectedPlan.getId(), selectedWorkout.getId());
        this.activeWorkout = editWorkoutViewModel.getActiveWorkout();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_edit_activeworkout_list_item, parent, false));
    }

    /**
     * Binds application data to the ViewHolder
     *
     * @param holder the ViewHolder
     * @param position current position in the exerciseList
     */
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.lblWorkoutExerciseName.setText(activeWorkout.getExercise(position).getName());
        holder.etbxNoOfReps.setText(activeWorkout.getExercise(position).getNoOfReps() + "");
        holder.etbxWeight.setText(0 + "");

        holder.etbxWeight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = holder.etbxWeight.getText().toString();
                if(txt.equals("")) {
                    holder.etbxNoOfReps.setText("0");
                }
                else {
                    editWorkoutViewModel.updateActiveExerciseWeight(Double.parseDouble(txt), activeWorkout.getExercise(position).getExerciseId());
                }
            }
        });
        holder.etbxNoOfReps.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = holder.etbxNoOfReps.getText().toString();
                if(txt.equals("")) {
                    holder.etbxNoOfReps.setText(editWorkoutViewModel.getActiveWorkout().getExercise(position).getNoOfReps());
                }
                else {
                    editWorkoutViewModel.updateActiveExerciseReps(Integer.parseInt(txt), activeWorkout.getExercise(position).getExerciseId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return activeWorkout.getExerciseList().size();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{


        public final TextView lblWorkoutExerciseName;
        private final EditText etbxNoOfReps;
        private final EditText etbxWeight;

        /**
         * Binds elements in layout file to the variables in the ViewHolder
         *
         * @param itemView the itemView
         */
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            lblWorkoutExerciseName = itemView.findViewById(R.id.lblWorkoutExerciseName);
            etbxNoOfReps = itemView.findViewById(R.id.etbxNoOfReps);
            etbxWeight= itemView.findViewById(R.id.etbxWeight);

        }
    }
}