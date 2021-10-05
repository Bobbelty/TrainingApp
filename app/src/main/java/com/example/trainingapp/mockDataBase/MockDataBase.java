package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.Plan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockDataBase {
    List<Plan> planList = new ArrayList<>();
    //It's possible to iterate through a hashMap, so this HashMap can be used for both
    //storing savedExercises and getting the savedExercises for display purposes.
    HashMap<String, Integer> ExerciseIdMap = new HashMap<>();

    public void addExerciseIdToMap(String key, Integer exerciseId) {
        ExerciseIdMap.put(key, exerciseId);
    }

    //need to implement try catch, due to nullpointerexception.
    public int getExerciseIdFromMap(String key){

            return ExerciseIdMap.get(key);
    }



    public void addPlan(Plan plan) {
    planList.add(plan);
    }

    public void removePlan(Plan plan){
    planList.remove(plan);
    }
}