package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

import java.util.List;

/**
 * Class for handling the objects in the application using a MockDatabase
 */
public class PlanBuilder {

    /**
     * Returns a new Plan-object
     *
     * @param planName the name of the plan
     */
    public Plan createNewPlan(String planName){
        return WorkoutPlanFactory.createPlan(planName);
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param plan the reference to the plan object
     * @param workoutName the name of the Workout-object that gets added to the Plan
     */
    public void addWorkoutToPlan(Plan plan, String workoutName) {
        Workout workout = WorkoutPlanFactory.createWorkout(workoutName);
        plan.addWorkout(workout);
    }

    /**
     * Method for removing a workout from a plan
     *
     * @param plan the reference to the plan object
     * @param workout the reference to the workout object
     */
    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        plan.removeWorkout(workout);
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param workout the reference to the workout object
     * @param exerciseName the name of the exercise
     */
    public void addExerciseToWorkout(Workout workout, String exerciseName, int exerciseID) {
        Exercise exercise = WorkoutPlanFactory.createExercise(exerciseName, exerciseID);
        workout.addExercise(exercise);
    }


    /**
     * Method for removing an exercise from a workout
     *
     * @param workout the reference to the workout object
     * @param exercise the reference to the exercise object
     */
    public void removeExerciseFromWorkout(Workout workout, Exercise exercise){
        workout.removeExercise(exercise);
    }
}
