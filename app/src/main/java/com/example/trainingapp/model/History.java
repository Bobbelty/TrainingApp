package com.example.trainingapp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for saving completed workouts, used for displaying all completed workouts in history-tab
 */
public class History {

    /**
     * List of all saved workouts
     */
    private List<Workout> savedWorkouts = new ArrayList<>();


    /**
     * Returns the list of saved workouts.
     * @return list of saved workouts
     */
    public List<Workout> getSavedWorkouts() {
        return savedWorkouts;
    }

    /**
     * Method for adding a completed workout to history
     *
     * @param workout object to add to list
     */
    public void addWorkoutToHistory(Workout workout) {
        savedWorkouts.add(workout);
    }
}
