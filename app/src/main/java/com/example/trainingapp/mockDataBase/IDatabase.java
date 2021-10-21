package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.ExerciseIdNotFoundException;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import java.util.List;

public interface IDatabase {
    List<Plan> getPlanList();

    List<ActiveWorkout> getCompletedWorkouts();

    void addPlan(Plan newPlan);

    void removePlan(String planId);

    void addToCompletedWorkouts(ActiveWorkout workout);

    int getExerciseIdFromMap(String exerciseName) throws ExerciseIdNotFoundException;

    void addExerciseIdToMap(String key, Integer exerciseId);

    void updatePlanName(String name, String Id);

    void removeWorkoutFromPlan(String planId, String workoutId);

    void addWorkoutToPlan(Workout workout, String planId);

    void updateWorkoutName(String name, String planId, String workoutId);

    void addExerciseToWorkout(Exercise exercise, String planId, String workoutId);

    void removeExerciseFromWorkout(String exerciseName, String planId, String workoutId);

    void updateExerciseName(String exerciseName, String planId, String workoutId, String exerciseId);

    void updateExerciseRep(int reps, String planId, String workoutId, String exerciseId);

    void newActiveWorkout(String planId, String workoutId);

    void addNewSet(String exerciseId);

    void updateActiveExerciseRep(int reps, String exerciseId, int index);

    void removeSetFromActiveExercise(String exerciseId, int index);

    void updateWeightInSet(String exerciseId, int index, int change);

    void endActiveWorkout();
}