package com.example.trainingapp.view.History.HistoryExercise;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.view.History.HistoryExercisesActivity;
import com.example.trainingapp.viewModel.HistoryViewModel;

/**
 * Adapter for the RecyclerView in the HistoryFragment provides the correct information for
 * each list item
 *
 * @author Philip Rabia and Patrik Olsson
 */
public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ListViewHolder>{

    private List<ActiveWorkout> completedWorkouts;
    private Context context;
    private Activity activity;
    private HistoryViewModel historyViewModel = HistoryViewModel.getInstance();

    /**
     * Constructor for adapter
     *
     * @param completedWorkouts list of completed workouts
     * @param activity the current activity
     * @param context the current state of the application
     */
    public HistoryRecyclerViewAdapter(List<ActiveWorkout> completedWorkouts, Activity activity, Context context) {
        this.completedWorkouts = completedWorkouts;
        this.activity = activity;
        this.context = context;
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

        return new HistoryRecyclerViewAdapter.ListViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_history_list_item, parent, false));

    }

    /**
     * Binds application data to the ViewHolder
     *
     * @param holder the ViewHolder
     * @param position current position in completedWorkouts
     */
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.lblActiveWorkoutName.setText(completedWorkouts.get(position).getName());
        holder.lblActiveWorkoutDate.setText(completedWorkouts.get(position).getDate());
        holder.btnViewExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyViewModel.setSelectedWorkout(completedWorkouts.get(position));

                activity.onBackPressed();
                Intent openActivity = new Intent(context, HistoryExercisesActivity.class);
                context.startActivity(openActivity);
            }
        });


    }

    /**
     * Return value is used to set the amount of items in the recyclerview
     * @return Returns the length of the list of items that is to be displayed
     */
    @Override
    public int getItemCount() { return completedWorkouts.size(); }

    /**
     * Class for the ListViewHolder that is used by this adapter
     */
    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView lblActiveWorkoutName;
        private final TextView lblActiveWorkoutDate;
        private final Button btnViewExercises;

        /**
         * Binds elements in layout file to the variables in the ViewHolder
         *
         * @param itemView the itemView
         */
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            lblActiveWorkoutName= itemView.findViewById(R.id.lblActiveWorkoutName);
            lblActiveWorkoutDate = itemView.findViewById(R.id.lblActiveWorkoutDate);
            btnViewExercises = itemView.findViewById(R.id.btnViewExercises);
        }
    }

}
