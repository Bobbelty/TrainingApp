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
import com.example.trainingapp.viewModel.EditScheduleViewModel;

public class EditScheduleRecyclerViewAdapter extends RecyclerView.Adapter<EditScheduleRecyclerViewAdapter.ListViewHolder> {


    private Activity activity;
    private Workout selectedWorkout;
    private Plan selectedPlan;
    private EditScheduleViewModel editScheduleViewModel = EditScheduleViewModel.getInstance();

    public EditScheduleRecyclerViewAdapter(Activity activity) {
        this.selectedWorkout = editScheduleViewModel.getSelectedWorkout();
        this.activity = activity;
        this.selectedPlan = editScheduleViewModel.getSelectedPlan();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_edit_schedule_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {


        holder.etbxExerciseName.setText(selectedWorkout.getExerciseList().get(position).getName());
        holder.etbxNoOfSets.setText(selectedWorkout.getExerciseList().get(position).getNumberOfSets() + "");
        holder.etbxNoOfReps.setText(selectedWorkout.getExerciseList().get(position).getNumberOfReps() + "");

        holder.btnDeleteExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                editScheduleViewModel.onClickRemoveExercise(
                        selectedPlan.getId(), selectedWorkout.getId(), selectedWorkout.getExerciseList().get(position).getId());
                selectedWorkout = editScheduleViewModel.getWorkoutById(selectedPlan.getId(), selectedWorkout.getId());
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
                    editScheduleViewModel.setNewNoOfSets(
                            Integer.parseInt(txt),
                            selectedPlan.getId(),
                            selectedWorkout.getId(),
                            selectedWorkout.getExercise(position).getId());
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
                    editScheduleViewModel.setNewNoOfReps(
                            Integer.parseInt(txt),
                            selectedPlan.getId(),
                            selectedWorkout.getId(),
                            selectedWorkout.getExercise(position).getId());
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
                    editScheduleViewModel.setNewExerciseName(
                            holder.etbxExerciseName.getText().toString(),
                            selectedPlan.getId(), selectedWorkout.getId(),
                            selectedWorkout.getExercise(position).getId());
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
        //private final TextView lblExercise;
        private final EditText etbxExerciseName;
        private final EditText etbxNoOfSets;
        private final EditText etbxNoOfReps;
        private final Button btnDeleteExercise;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            //lblExercise = itemView.findViewById(R.id.lblExercise);
            etbxExerciseName = itemView.findViewById(R.id.etbxExerciseName);
            etbxNoOfSets = itemView.findViewById(R.id.etbxNoOfSets);
            etbxNoOfReps = itemView.findViewById(R.id.etbxNoOfReps);
            btnDeleteExercise = itemView.findViewById(R.id.btnDeleteExercise);

        }
    }
}