package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.MockDataBase;

public class PlanBuilder {
    private MockDataBase mockDatabase;

    public void addPlanToDatabase(String planName){
<<<<<<< HEAD
        mockDatabase.addPlan(WorkoutPlanFactory.createPlan(planName));
=======
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
>>>>>>> a9905d6cb7b8ff6d6d0d1478a628db60570defb0
    }

    public void addWorkoutToPlan(Plan plan, String name) {
        Workout workout = WorkoutPlanFactory.createWorkout(name);
        plan.addWorkout(workout);
    }

    public void removeWorkoutFromPlan(Plan plan, Workout workout) {
        plan.removeWorkout(workout);
    }

    public void addExerciseToWorkout(Workout workout, String exerciseName) {
        int exerciseId = mockDatabase.getExerciseIdFromMap(exerciseName);
        Exercise exercise = WorkoutPlanFactory.createExercise(exerciseName, exerciseId);
        workout.addExercise(exercise);
    }
<<<<<<< HEAD
=======

    public void removeExerciseFromWorkout(Workout workout, Exercise exercise){
        workout.removeExercise(exercise);
    }


>>>>>>> a9905d6cb7b8ff6d6d0d1478a628db60570defb0
}
