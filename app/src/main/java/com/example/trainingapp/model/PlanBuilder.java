package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

public class PlanBuilder {
    private MockDataBase mockDatabase;

    //look at later
    public void addPlanToDatabase(String planName){
        mockDatabase.addPlan(WorkoutPlanFactory.createPlan(planName));
    }

    public void addWorkoutToPlan(Plan plan, String name) {
        Workout workout = WorkoutPlanFactory.createWorkout(name);
        plan.addWorkout(workout);
    }

    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        plan.removeWorkout(workout);
    }

    public void addExerciseToWorkout(Workout workout, String exerciseName) {
        try{
            int exerciseId = mockDatabase.getExerciseIdFromMap(exerciseName);
            Exercise exercise = WorkoutPlanFactory.createExercise(exerciseName, exerciseId);
            workout.addExercise(exercise);
        } catch (ExerciseIdNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void removeExerciseFromWorkout(Workout workout, Exercise exercise){
        workout.removeExercise(exercise);
    }



}
