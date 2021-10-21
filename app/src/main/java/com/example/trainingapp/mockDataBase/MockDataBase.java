package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.ExerciseIdNotFoundException;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class MockDataBase implements IDatabase {
    private final LinkedHashMap<String, Plan> planMap = new LinkedHashMap<>();

    private final List<ActiveWorkout> completedWorkouts = new ArrayList<>();

    /*It's possible to iterate through a hashMap, so this HashMap can be used for both
    storing savedExercises and getting the savedExercises for display purposes.*/

    LinkedHashMap<String, Integer> ExerciseIdMap = new LinkedHashMap<>();
    LinkedHashMap<Integer, Integer> currentPBs = new LinkedHashMap<>();


    public MockDataBase(){

        Plan examplePlan1 = new Plan();
        examplePlan1.setPlanName("Bulk");
        Workout exampleWorkout1 = new Workout();
        exampleWorkout1.setName("Chest & Shoulder");

        Exercise exampleExercise1 = new Exercise();
        Exercise exampleExercise2 = new Exercise();

        Workout exampleWorkout2 = new Workout();
        exampleWorkout2.setName("Legs");
        Exercise exampleExercise3 = new Exercise();
        Exercise exampleExercise4 = new Exercise();

        exampleExercise1.setName("Benchpress");
        exampleExercise2.setName("Shoulderpress");
        exampleExercise3.setName("Legpress");
        exampleExercise4.setName("Bicepcurls");

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

        examplePlan1 = new Plan();
        examplePlan1.setPlanName("Deff");
        exampleWorkout2 = new Workout();
        exampleWorkout2.setName("Heavy chest");
        exampleExercise3 = new Exercise();
        exampleExercise4 = new Exercise();

        exampleWorkout1 = new Workout();
        exampleWorkout1.setName("Backday");
        exampleExercise1 = new Exercise();

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

        ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();
        ActiveWorkout activeWorkout1 = activeWorkoutSession.convertWorkoutToActiveWorkout(exampleWorkout1);
        ActiveWorkout activeWorkout2 = activeWorkoutSession.convertWorkoutToActiveWorkout(exampleWorkout2);
        activeWorkoutSession.setCurrentDate(activeWorkout1);
        activeWorkoutSession.setCurrentDate(activeWorkout2);
        completedWorkouts.add(activeWorkout1);
        completedWorkouts.add(activeWorkout2);

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
        planMap.put(plan.getId(), plan);
    }

    public void removePlan(String id){
        planMap.remove(id);
    }

    public void updatePlanName(String name, String id){
        planMap.get(id).setPlanName(name);
    }

    //TODO fix this nullpointerexception.
    public List<Plan> getPlanList() {
        List<Plan> planListCopy = new ArrayList();
        for(String key : planMap.keySet()){
                planListCopy.add(new Plan(planMap.get(key)));
        }
        return planListCopy;
    }

    public Plan getPlan(String planId){
        return planMap.get(planId);
    }

    public Workout getWorkout(String planId, String workoutId) {
        return planMap.get(planId).getWorkout(workoutId);
    }
    public List<ActiveWorkout> getCompletedWorkouts() {
        return new ArrayList<>(completedWorkouts);
    }

    public void addToCompletedWorkouts(ActiveWorkout workout) {completedWorkouts.add(workout);}

    public HashMap<Integer, Integer> getCurrentPBs() {
        return currentPBs;
    }

    public void addToCurrentPBs(Integer exerciseId, Integer newWeight) {
        currentPBs.put(exerciseId, newWeight);
    }

    public void updateWorkoutName(String name, String planId, String workoutId){
        Plan plan = planMap.get(planId);
        plan.setWorkoutName(name, workoutId);
    }

    public void removeWorkoutFromPlan(String planId, String workoutId){
        planMap.get(planId).removeWorkout(workoutId);
    }

    public void addWorkoutToPlan(Workout workout, String planId){
        planMap.get(planId).addWorkout(workout);
    }

    public void addExerciseToWorkout(Exercise exercise, String planId, String workoutId){
        planMap.get(planId).addExerciseToWorkout(exercise, workoutId);
    }

    public void removeExerciseFromWorkout(String planId, String workoutId, String exerciseId) {
        planMap.get(planId).removeExerciseFromWorkout(workoutId, exerciseId);
    }

    public void updateExerciseName(String exerciseName, String planId, String workoutId, String exerciseId){
        planMap.get(planId).updateExerciseNameInWorkout(exerciseName, workoutId, exerciseId);

    }
}