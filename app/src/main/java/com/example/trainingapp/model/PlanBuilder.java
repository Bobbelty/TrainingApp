package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

import java.util.List;

public class PlanBuilder {
    private MockDataBase mockDatabase;

    public void addPlanToDatabase(String planName){
        mockDatabase.addPlan(createEmptyPlan(planName));
    }
    private Plan createEmptyPlan(String name){
        return PlanFactory.createPlan(name);
    }

    private Workout createEmptyWorkout(String workoutName) {
        return WorkoutFactory.createWorkout(workoutName);
    }

    private Exercise createExercise(String exerciseName, int exerciseId) {
        return ExerciseFactory.createExercise(exerciseName, exerciseId);
    }

    public void addWorkoutToPlan(Plan plan, String name) {
        Workout workout = createEmptyWorkout(name);
        plan.addWorkout(workout);
    }

    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        plan.removeWorkout(workout);
    }

    public void addExerciseToWorkout(Workout workout, String exerciseName) {
        int exerciseId = mockDatabase.getExerciseIdFromMap(exerciseName);
        Exercise exercise = createExercise(exerciseName, exerciseId);
        workout.addExercise(exercise);
    }


}
