package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockDataBase {
    List<Plan> planList = new ArrayList<>();
    //It's possible to iterate through a hashMap, so this HashMap can be used for both
    //storing savedExercises and getting the savedExercises for display purposes.
    HashMap<String, Integer> ExerciseTypeHM = new HashMap<>();

    public void addExerciseTypeToHashMap(String name, Integer id) {
        ExerciseTypeHM.put(name, id);
    }



    public void addPlan(Plan plan) {
    planList.add(plan);
    }

    public void removePlan(Plan plan){
    planList.remove(plan);
    }
}