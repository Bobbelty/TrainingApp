package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.ExerciseIdNotFoundException;
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MockDataBase {
    List<Plan> planList = new ArrayList<>();
    /*It's possible to iterate through a hashMap, so this HashMap can be used for both
    storing savedExercises and getting the savedExercises for display purposes.*/

    HashMap<String, Integer> ExerciseIdMap = new HashMap<>();


    public MockDataBase(){

        Plan examplePlan = new Plan("examplePlan1");
        Workout exampleWorkout = new Workout("exampleWorkout1");
        Exercise exampleExercise = new Exercise("Bench Press", 123);

        exampleExercise.addSet(12);
        exampleExercise.addSet(12);
        exampleExercise.addSet(12);

        exampleWorkout.addExercise(exampleExercise);
        examplePlan.addWorkout(exampleWorkout);

        addPlan(examplePlan);
    }

    public void addExerciseIdToMap(String key, Integer exerciseId) {
        ExerciseIdMap.put(key, exerciseId);
    }

    public int getExerciseIdFromMap(String key) throws ExerciseIdNotFoundException {
        if(ExerciseIdMap.get(key) != null){
            return ExerciseIdMap.get(key);
        }
        throw new ExerciseIdNotFoundException("That ExerciseId has not been added to mockDatabase");
    }

    public void addPlan(Plan plan) {
    planList.add(plan);
    }

    public void removePlan(Plan plan){
    planList.remove(plan);
    }
}