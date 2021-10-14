package com.example.trainingapp.model;

import java.util.Calendar;

/**
 * Class handling logic for ActiveExercise and ActiveWorkout
 */
public class ActiveWorkoutSession {

    public ActiveWorkout convertWorkoutToActiveWorkout(Workout workout){
        ActiveWorkout activeWorkout = new ActiveWorkout(workout.getName());
        for(int i = 0; i < workout.getExerciseList().size(); i++){
            String activeName = workout.getExerciseList().get(i).getName();
            int activeReps = workout.getExerciseList().get(i).getNumberOfReps();
            int activeSets = workout.getExerciseList().get(i).getNumberOfSets();
            int activeId = workout.getExerciseList().get(i).getExerciseId();
            activeWorkout.addExercise(ActiveWorkoutComponentFactory.createActiveExercise(activeName, activeId, activeReps, activeSets));
        }
        return activeWorkout;
    }

    public void setCurrentDate (ActiveWorkout activeWorkout){
        activeWorkout.setCurrentTime(Calendar.getInstance().getTime());
    }

}
