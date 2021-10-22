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

public class EditWorkoutRecyclerViewAdapter extends RecyclerView.Adapter<EditWorkoutRecyclerViewAdapter.ListViewHolder> {


    private Activity activity;
    private Plan selectedPlan;
    private EditWorkoutViewModel editWorkoutViewModel = EditWorkoutViewModel.getInstance();
    private Workout selectedWorkout;
    private ActiveWorkout activeWorkout;

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

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.lblWorkoutExerciseName.setText(activeWorkout.getExercise(position).getName());
        holder.etbxNoOfReps.setText(activeWorkout.getExercise(position).getNoOfReps() + "");
        holder.etbxWeight.setText(0 + "");
        //holder.lblWorkoutExerciseName.setText(selectedWorkout.getExerciseList().get(position).getName());
        //holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getNumberOfReps() + "");
        //holder.etbxWeight.setText(0 + "");


        holder.etbxWeight.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = holder.etbxWeight.getText().toString();
                if(txt.equals("")) {

                }
                else {

                }
            }
        });
        holder.etbxNoOfReps.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                String txt = holder.etbxNoOfReps.getText().toString();
                if(txt.equals("")) {

                }
                else {

                }
            }
        });
    }
    // Benchpress 3 4


    // Benchpress rep + vikt
    // Benchjpress rep + vikt
    // Benchjpress rep + vikt

    @Override
    public int getItemCount() {
        return activeWorkout.getExerciseList().size();
    }
    private List<Exercise> expandWorkoutList() {
       /* List<Exercise> exerciseList = new ArrayList<>();
        for (int i = 0; i < selectedWorkout.getExerciseList().size(); i++) {
            for (int k = 0; k < selectedWorkout.getExerciseList().get(i).getNumberOfSets(); k++) {
                exerciseList.add(selectedWorkout.getExerciseList().get(i));
            }
        }
        Workout expandedWorkout = new Workout();
        for (int i = 0; i < exerciseList.size(); i++) {
            expandedWorkout.addExercise(exerciseList.get(i));
        }
        editWorkoutViewModel.createActiveWorkout(selectedPlan.getId(), expandedWorkout.getId());
        return exerciseList;*/
        return null;
    }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        //change name, make private maybe final
        //private final TextView lblExercise;
        public TextView lblWorkoutExerciseName;
        private final EditText etbxNoOfReps;
        private final EditText etbxWeight;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            //lblExercise = itemView.findViewById(R.id.lblExercise);
            lblWorkoutExerciseName = itemView.findViewById(R.id.lblWorkoutExerciseName);
            etbxNoOfReps = itemView.findViewById(R.id.etbxNoOfReps);
            etbxWeight= itemView.findViewById(R.id.etbxWeight);

        }
    }
}