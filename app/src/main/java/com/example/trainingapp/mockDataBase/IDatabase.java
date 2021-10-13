package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.ExerciseIdNotFoundException;
import com.example.trainingapp.model.Plan;

import java.util.List;

public interface IDatabase {
    List<Plan> getPlanList();

    void addPlan(Plan newPlan);

    int getExerciseIdFromMap(String exerciseName) throws ExerciseIdNotFoundException;
    void addExerciseIdToMap(String key, Integer exerciseId);
}
