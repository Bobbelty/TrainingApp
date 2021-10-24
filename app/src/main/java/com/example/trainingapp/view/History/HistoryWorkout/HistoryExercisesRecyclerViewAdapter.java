package com.example.trainingapp.view.History.HistoryWorkout;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;

/**
 * Adapter for the RecyclerView in the HistoryExercisesFragment, provides the correct information for
 * each list item
 *
 * @author Philip Rabia and Patrik Olsson
 */
public class HistoryExercisesRecyclerViewAdapter extends RecyclerView.Adapter<HistoryExercisesRecyclerViewAdapter.ListViewHolder>{

    private ActiveWorkout selectedWorkout;

    /**
     * Constructor for adapter
     *
     * @param selectedWorkout the selected workout from HistoryFragment page
     */
    public HistoryExercisesRecyclerViewAdapter(ActiveWorkout selectedWorkout) {
        this.selectedWorkout = selectedWorkout;
    }

    /**
     * onCreateViewHolder creates and returns the ViewHolder hierarchy associated with the adapter.
     *
     * @param parent
     * @param viewType
     * @return Return the ListViewHolder for the adapter, or null.
     */
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HistoryExercisesRecyclerViewAdapter.ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_exercise_history_list_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if  (position > 0) {
            if (!(selectedWorkout.getExercise(position).getName().equals(selectedWorkout.getExercise(position-1).getName()))) {
                holder.lblViewExerciseName.setText(selectedWorkout.getExercise(position).getName() + "");
            }
        }
        else {
            holder.lblViewExerciseName.setText(selectedWorkout.getExercise(position).getName() + "");
        }
        holder.lblViewExerciseReps.setText(selectedWorkout.getExercise(position).getNoOfReps() + "");
        holder.lblViewExerciseWeight.setText(selectedWorkout.getExercise(position).getWeights() + "");
    }

    @Override
    public int getItemCount() { return selectedWorkout.getExerciseList().size(); }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView lblViewExerciseName;
        private final TextView lblViewExerciseReps;
        private final TextView lblViewExerciseWeight;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            lblViewExerciseName = itemView.findViewById(R.id.lblViewExerciseName);
            lblViewExerciseReps = itemView.findViewById(R.id.lblViewExerciseReps);
            lblViewExerciseWeight = itemView.findViewById(R.id.lblViewExerciseWeight);

        }
    }

}
