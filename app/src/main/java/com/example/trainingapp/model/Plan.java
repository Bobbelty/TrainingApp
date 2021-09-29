package com.example.trainingapp.model;

import java.util.List;

public class Plan {
    // Make sure not able to send null values from GUI
    private String planName; // test with and without final, best to use final if possible
    private List<Workout> workouts; // test with and without final, best to use final if possible

    public String getPlanName() {
        return planName;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    public Plan(String planName, List<Workout> workouts) {
        this.planName = planName;
        this.workouts = workouts;
    }

    void deleteWorkout(String workoutName) {
        for (Workout w: workouts) {
            if (w.getName().equals(workoutName)) { // sus?
                workouts.remove(w);
            }
        }
    }
    void addWorkout(Workout workout) {
        workouts.add(workout); // not sus
    }
    // method for changing workout?
    void changeWorkout(Workout changedWorkout, String oldWorkoutName) {
        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).getName() == oldWorkoutName) {
                workouts.set(i, changedWorkout);
            }
        }
    }
    @Override
    public String toString() {
        return planName;
    }
}