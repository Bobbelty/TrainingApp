package com.example.trainingapp.model.components;


/**
 * Class providing static methods for creating resources
 *  @author Victor Hui, Valdemar Vålvik
 */
public class PlanComponentFactory {

    /**
     * Static method for creating a new Plan-object
     *
     * @return a plan object
     */
    public static Plan createPlan(){return new Plan();}

    /**
     * Static method for creating a new Workout-object
     *
     * @return a workout object
     */
    public static Workout createWorkout(){return new Workout();}

    /**
     * Static method for creating a new Exercise-object
     *
     * @return a exercise object
     */
    public static Exercise createExercise(){return new Exercise();}
}
