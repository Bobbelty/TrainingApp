package com.example.trainingapp.model.components;


/**
 * Class providing static methods for creating resources
 */
public class PlanComponentFactory {
    
    public static Plan createPlan(){return new Plan();}

    public static Workout createWorkout(){return new Workout();}

    public static Exercise createExercise(){return new Exercise();}
}
