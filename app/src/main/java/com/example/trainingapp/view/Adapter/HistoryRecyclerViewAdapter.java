package com.example.trainingapp.view.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainingapp.R;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;

/**
 * Adapter for the RecyclerView in the HistoryActivity, provides the correct information for
 * each list item
 */
public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<HistoryRecyclerViewAdapter.ListViewHolder>{

    private List<ActiveWorkout> completedWorkouts;
    private Context context;
    private Activity activity;

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
        holder.lblActiveWorkoutDate.setText(completedWorkouts.get(position).getTime());

    }

    @Override
    public int getItemCount() { return completedWorkouts.size(); }

    static class ListViewHolder extends RecyclerView.ViewHolder{

        private final TextView lblActiveWorkoutName;
        private final TextView lblActiveWorkoutDate;

        /**
         * Binds elements in layout file to the variables in the ViewHolder
         *
         * @param itemView the itemView
         */
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            lblActiveWorkoutName= itemView.findViewById(R.id.lblActiveWorkoutName);
            lblActiveWorkoutDate = itemView.findViewById(R.id.lblActiveWorkoutDate);
        }
    }

}
