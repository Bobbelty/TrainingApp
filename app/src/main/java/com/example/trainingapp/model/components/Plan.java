package com.example.trainingapp.model.components;

import java.util.ArrayList;
import java.util.List;


/**
 * A class for building a workoutplan that contains zero or more workouts.
 *
 * @author ...
 */
public class Plan {

    /**
     * Variable for holding the plan name
     */
    private String planName; // Make sure not able to send null values from GUI

    /**
     * The list containing all the workouts in the plan
     */
    private List<Workout> workouts = new ArrayList<>();

    /**
     * Class constructor setting planName
     *
     * @param planName name of plan
     */
    public Plan(String planName) {
        this.planName = planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanName() {
        return planName;
    }

    /**
     * Method for removing a workoutobject from the list of workouts
     *
     * @param workout workoutobject to be removed from list
     */
    void removeWorkout(Workout workout) {
        workouts.remove(workout);
    }

    /**
     * Method for getting the list Workouts that Plan contains
     * @return The list of Workouts that Plan contains
     */
    public List<Workout> getWorkoutList(){
        return workouts;
    }


    /**
     * Method for adding a workoutobject to the list of workouts
     *
     * @param workout workoutobject to add to list
     */
    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }
    @Override
    public String toString() {
        return planName;
    }
}