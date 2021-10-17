package com.example.trainingapp.model;



/**
 * Class providing static methods for creating resources
 */
public class ActiveWorkoutComponentFactory {

    public static ActiveWorkout createActiveWorkout(String name){return new ActiveWorkout(name);}

    public static ActiveExercise createActiveExercise(String name, int id, int reps, int sets)
        {return new ActiveExercise(name, id, reps, sets);}

}
