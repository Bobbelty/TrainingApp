package com.example.trainingapp.model.activeComponents;

import com.example.trainingapp.model.components.Exercise;

/**
 * Factory-class providing static methods for creating components of an active workout.
 */
public class ActiveWorkoutComponentFactory {

    /**
     * Static method for creating a new ActiveWorkout.
     *
     * @param name the name of the new ActiveWorkout
     * @return the new ActiveWorkout-object
     */
    public static ActiveWorkout createActiveWorkout(String name){return new ActiveWorkout(name);}

    /**
     * Static method for creating a new ActiveExercise.
     *
     * @param exercise what exercise to be converted into a new ActiveExercise
     * @return a new ActiveExercise
     */
    public static ActiveExercise createActiveExercise(Exercise exercise){
        return new ActiveExercise(exercise);
    }
}
