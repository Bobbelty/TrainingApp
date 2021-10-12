package com.example.trainingapp.model;

import java.util.List;


/**
 * Class providing static methods for creating resources
 */
public class PlanComponentFactory {

    /**
     * Method for creating a new plan
     *
     * @param name the name of the new plan
     * @return the reference to the new Plan object
     */
    public static Plan createPlan(String name){return new Plan(name);}

    /**
     * Method for creating a new workout
     *
     * @param name the name of the new workout
     * @return the reference to the new Workout object
     */
    public static Workout createWorkout(String name){return new Workout(name);}

    /**
     * Method for creating a new exercise
     *
     * @param exerciseName the name of the new exercise
     * @param exerciseId the Id of the new exercise
     * @return the reference to the new Exercise object
     */
    public static Exercise createExercise(String exerciseName, int exerciseId){return new Exercise(exerciseName, exerciseId);}
}
