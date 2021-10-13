package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.Exercise;
import com.example.trainingapp.model.ExerciseIdNotFoundException;
import com.example.trainingapp.model.Plan;
import com.example.trainingapp.model.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MockDataBase implements IDatabase {
    List<Plan> planList = new ArrayList<>();
    List<Workout> completedWorkouts = new ArrayList<>();

    /*It's possible to iterate through a hashMap, so this HashMap can be used for both
    storing savedExercises and getting the savedExercises for display purposes.*/

    HashMap<String, Integer> ExerciseIdMap = new HashMap<>();
    HashMap<Integer, Integer> currentPBs = new HashMap<>();


    public MockDataBase(){

        Plan examplePlan1 = new Plan("Summer");
        Workout exampleWorkout1 = new Workout("Breast and shoulders");
        Exercise exampleExercise1 = new Exercise("Bench Press", 123);
        Exercise exampleExercise2 = new Exercise("Military Press", 124);

        Workout exampleWorkout2 = new Workout("Legs");
        Exercise exampleExercise3 = new Exercise("Squats", 125);
        Exercise exampleExercise4 = new Exercise("Leg press", 126);

        exampleExercise1.setNumberOfSets(4);
        exampleExercise1.setNumberOfReps(8);

        exampleExercise2.setNumberOfSets(5);
        exampleExercise2.setNumberOfReps(10);

        exampleExercise3.setNumberOfSets(4);
        exampleExercise3.setNumberOfReps(4);

        exampleExercise4.setNumberOfSets(6);
        exampleExercise4.setNumberOfReps(12);

        exampleWorkout1.addExercise(exampleExercise1);
        exampleWorkout1.addExercise(exampleExercise2);
        exampleWorkout1.addExercise(exampleExercise3);
        exampleWorkout1.addExercise(exampleExercise4);
        examplePlan1.addWorkout(exampleWorkout1);
        examplePlan1.addWorkout(exampleWorkout2);

        addPlan(examplePlan1);

        examplePlan1 = new Plan("Winter");
        exampleWorkout2 = new Workout("Breast and shoulders");
        exampleExercise3 = new Exercise("Bench Press", 123);
        exampleExercise4 = new Exercise("Military Press", 124);

        exampleWorkout1 = new Workout("Legs");
        exampleExercise1 = new Exercise("Squats", 125);
        exampleExercise2 = new Exercise("Leg press", 126);

        exampleExercise1.setNumberOfSets(4);
        exampleExercise1.setNumberOfReps(8);

        exampleExercise2.setNumberOfSets(5);
        exampleExercise2.setNumberOfReps(10);

        exampleExercise3.setNumberOfSets(4);
        exampleExercise3.setNumberOfReps(4);

        exampleExercise4.setNumberOfSets(6);
        exampleExercise4.setNumberOfReps(12);

        exampleWorkout1.addExercise(exampleExercise1);
        exampleWorkout1.addExercise(exampleExercise2);
        exampleWorkout1.addExercise(exampleExercise3);
        exampleWorkout1.addExercise(exampleExercise4);
        examplePlan1.addWorkout(exampleWorkout1);
        examplePlan1.addWorkout(exampleWorkout2);

        addPlan(examplePlan1);
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

    public List<Plan> getPlanList(){
        return planList;
    }

    public List<Workout> getCompletedWorkouts() {
        return completedWorkouts;
    }

    public void addToCompletedWorkouts(Workout workout) {completedWorkouts.add(workout);}

    public HashMap<Integer, Integer> getCurrentPBs() {
        return currentPBs;
    }

    public void addToCurrentPBs(Integer exerciseId, Integer newWeight) {
        currentPBs.put(exerciseId, newWeight);
    }
}