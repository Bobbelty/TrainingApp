package com.example.trainingapp.model;

import java.util.Calendar;

/**
 * Class handling logic for ActiveExercise and ActiveWorkout
 */
public class ActiveWorkoutSession {

    public ActiveWorkout convertWorkoutToActiveWorkout(Workout workout){
        ActiveWorkout activeWorkout = new ActiveWorkout(workout.getName());
        return activeWorkout;
    }

}
