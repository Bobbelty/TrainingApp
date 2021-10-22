package com.example.trainingapp.model.components;

/**
 * Class for handling the objects in the application using a MockDatabase
 */
public class PlanBuilder {

    /**
     * Returns a new Plan-object
     *
     * @return a plan object
     */
    public Plan createNewPlan(){
        return PlanComponentFactory.createPlan();
    }

    /**
     * Returns a new Workout-object
     *
     * @return a workout object
     */
    public Workout createNewWorkout() {
        return PlanComponentFactory.createWorkout();
    }

    /**
     * Returns a new Exercise-object
     *
     * @return a exercise object
     */
    public Exercise createNewExercise() {
        return PlanComponentFactory.createExercise();
    }
}
