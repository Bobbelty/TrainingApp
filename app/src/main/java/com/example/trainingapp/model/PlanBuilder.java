package com.example.trainingapp.model;

import java.util.List;

public class PlanBuilder {

    private Plan createEmptyPlan(String name){
        return PlanFactory.createPlan(name);
    }

    private Workout createEmptyWorkout(String workoutName) {
        return WorkoutFactory.createWorkout(workoutName);
    }

    private Exercise createExercise(String exerciseName) {
        return ExerciseFactory.createExercise(exerciseName);
    }

    public void addWorkoutToPlan(Plan plan, String name) {
        Workout workout = createEmptyWorkout(name);
        plan.addWorkout(workout);
    }

    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        plan.removeWorkout(workout);
    }

    public void addExerciseToWorkout(Workout workout,String name) {
        Exercise exercise = createExercise(name);
        workout.addExercise(exercise);
    }
}
