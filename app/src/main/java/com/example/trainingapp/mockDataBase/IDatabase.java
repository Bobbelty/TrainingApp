package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.ExerciseIdNotFoundException;
import com.example.trainingapp.model.components.Plan;

import java.util.List;

public interface IDatabase {
    List<Plan> getPlanList();

    List<ActiveWorkout> getCompletedWorkouts();

    void addPlan(Plan newPlan);

    void addToCompletedWorkouts(ActiveWorkout workout);

    int getExerciseIdFromMap(String exerciseName) throws ExerciseIdNotFoundException;

    void addExerciseIdToMap(String key, Integer exerciseId);
}
