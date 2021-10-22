package com.example.trainingapp.model.activeComponents;

import com.example.trainingapp.model.components.Workout;

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
        ActiveWorkout activeWorkout = ActiveWorkoutComponentFactory.createActiveWorkout(workout.getName());
        
        for(int i = 0; i < workout.getExerciseList().size(); i++){
            
            activeWorkout.addExercise(ActiveWorkoutComponentFactory.createActiveExercise(workout.getExerciseList().get(i)));
        }
        return activeWorkout;
    }
    /**
     * Method for getting the current date for an active workout, used to show when the user has
     * done the workout when looking at history. Uses the java Calendar class to get the current
     * time.
     *
     * @return the date in yyyy-MM-dd format as a string
     */
    public String getCurrentDate (){
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}