package com.example.trainingapp.model;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class handling logic for ActiveExercise and ActiveWorkout
 */
public class ActiveWorkoutSession {

    /**
     * Method for converting a Workout-object to an Active Workout. This includes converting the
     * list of exercises inside the Workout-object to a new list with ActiveExercises inside the
     * new ActiveWorkout.
     *
     * @param workout Workout-object to be converted into the ActiveWorkout
     * @return a new ActiveWorkout
     */
    public ActiveWorkout convertWorkoutToActiveWorkout(Workout workout){
        ActiveWorkout activeWorkout = new ActiveWorkout(workout.getName());
        
        for(int i = 0; i < workout.getExerciseList().size(); i++){
            
            activeWorkout.addExercise(ActiveWorkoutComponentFactory.createActiveExercise(workout.getExerciseList().get(i)));
        }
        return activeWorkout;
    }

    /**
     * Method for setting a datestamp to the active workout when it is ended.
     *
     * @param activeWorkout which active workout to set the date on.
     */
    public void setCurrentDate (ActiveWorkout activeWorkout){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String workoutDate = dateFormat.format(date);
        activeWorkout.setCurrentTime(workoutDate);
    }
}
