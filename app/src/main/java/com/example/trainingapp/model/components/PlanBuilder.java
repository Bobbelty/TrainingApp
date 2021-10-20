package com.example.trainingapp.model.components;

/**
 * Class for handling the objects in the application using a MockDatabase
 */
public class PlanBuilder {

    /**
     * Returns a new Plan-object
     *
     * @param planName the name of the plan
     */
    public Plan createNewPlan(){
        return PlanComponentFactory.createPlan();
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param plan the reference to the plan object
     * @param workoutName the name of the Workout-object that gets added to the Plan
     */
    public Workout createNewWorkout() {
        return PlanComponentFactory.createWorkout();
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param workout the reference to the workout object
     * @param exerciseName the name of the exercise
     */
    public Exercise createNewExercise() {
        return PlanComponentFactory.createExercise();
    }
}
