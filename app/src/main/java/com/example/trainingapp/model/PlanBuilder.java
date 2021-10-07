package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

/**
 * Class for handling the objects in the application using a MockDatabase
 */
public class PlanBuilder {

    /**
     * PlanBuilder uses a MockDatabase to store plans, workouts and exercises
     * during runtime
     */
    private MockDataBase mockDatabase;

    /**
     * Method for adding a plan to the mockDatabase
     *
     * @param planName the name of the plan
     */
    //look at later
    public void addPlanToDatabase(String planName){
        mockDatabase.addPlan(WorkoutPlanFactory.createPlan(planName));
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param plan the reference to the plan object
     * @param name the name of the workout
     */
    public void addWorkoutToPlan(Plan plan, String name) {
        Workout workout = WorkoutPlanFactory.createWorkout(name);
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
    public void addExerciseToWorkout(Workout workout, String exerciseName) {
        try{
            int exerciseId = mockDatabase.getExerciseIdFromMap(exerciseName);
            Exercise exercise = WorkoutPlanFactory.createExercise(exerciseName, exerciseId);
            workout.addExercise(exercise);
        } catch (ExerciseIdNotFoundException e) {
            e.printStackTrace();
        }
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
