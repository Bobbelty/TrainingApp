package com.example.trainingapp.model;



/**
 * Class providing static methods for creating resources
 */
public class ActiveWorkoutComponentFactory {

    public static ActiveWorkout createActiveWorkout(String name){return new ActiveWorkout(name);}

    public static ActiveExercise createActiveExercise(Exercise exercise){
        return new ActiveExercise(exercise);
    }
}
