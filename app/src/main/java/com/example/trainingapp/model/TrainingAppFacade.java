package com.example.trainingapp.model;

/**
 * The TrainingApp-class purpose is to act as a facade of the model towards the ViewModels.
 * It contains method for communication with the database. Furthermore it can access the model
 * through a PlanBuilder-object.
 */
public class TrainingAppFacade {
    private User user = new User();


    public void createNewPlan(String planName){
        user.createNewPlan(planName);
    }

    public void addWorkoutToPlan(Plan plan, String workoutName){
        user.addWorkoutToPlan(plan, workoutName);
    }

    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        user.removeWorkoutFromPlan(plan, workout);
    }

    public void addExerciseToWorkout(Workout workout, String exerciseName ){
        user.addExerciseToWorkout(workout,exerciseName);

    }

    public void removeExerciseFromWorkout(Workout workout, Exercise exercise){
        user.removeExerciseFromWorkout(workout, exercise);
    }





}
