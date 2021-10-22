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

    private final ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();

    private ActiveWorkout activeWorkout;

    private final List<ActiveWorkout> completedWorkouts = new ArrayList<>();

    /*It's possible to iterate through a hashMap, so this HashMap can be used for both
    storing savedExercises and getting the savedExercises for display purposes.*/

    LinkedHashMap<String, Integer> ExerciseIdMap = new LinkedHashMap<>();
    LinkedHashMap<Integer, Integer> currentPBs = new LinkedHashMap<>();


    public MockDataBase(){

        Plan examplePlan1 = new Plan();
        examplePlan1.setPlanName("Bulk");

        Workout exampleWorkout1 = new Workout();
        exampleWorkout1.setName("Chest and shoulders");
        Workout exampleWorkout2 = new Workout();
        exampleWorkout2.setName("Back");

        Exercise exampleExercise0 = new Exercise("Dips");
        Exercise exampleExercise1 = new Exercise("Bench Press");
        Exercise exampleExercise2 = new Exercise("Military Press");

        Workout exampleWorkout5 = new Workout();
        exampleWorkout5.setName("Legs");
        Exercise exampleExercise3 = new Exercise("Squats");
        Exercise exampleExercise4 = new Exercise("Leg press");

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

        exampleWorkout2 = new Workout();
        exampleExercise3 = new Exercise("Bench Press");
        exampleExercise4 = new Exercise("Military Press");

        exampleWorkout1 = new Workout();
        exampleExercise1 = new Exercise("Squats");
        exampleExercise2 = new Exercise("Leg press");

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
        activeWorkout1.setCurrentTime("2020-05-12");
        activeWorkout2.setCurrentTime("2019-10-02");
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
        return new Plan(planMap.get(planId));
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
        planMap.get(planId).updateExerciseName(exerciseName, workoutId, exerciseId);
    }

    public void updateExerciseRep(int reps, String planId, String workoutId, String exerciseId){
        planMap.get(planId).updateExerciseRep(workoutId, exerciseId, reps);
    }

    public void updateExerciseSets(int sets, String planId, String workoutId, String exerciseId){
        planMap.get(planId).updateExerciseSets(workoutId, exerciseId, sets);
    }

    public void newActiveWorkout(String planId, String workoutId){
        Workout workout = new Workout(planMap.get(planId).getWorkout(workoutId));
        activeWorkout = activeWorkoutSession.convertWorkoutToActiveWorkout(workout);
    }

    public ActiveWorkout getActiveWorkout(){
        return new ActiveWorkout(activeWorkout);
    }

    public void updateActiveExerciseRep(int reps, String exerciseId, int index){
        activeWorkout.updateActiveExerciseRep(reps, exerciseId, index);
    }

    public void addNewSet(String exerciseId){
        activeWorkout.addSetToExercise(exerciseId);
    }

    public void removeSetFromActiveExercise(String exerciseId, int index){
        activeWorkout.removeSetFromExercise(exerciseId, index);
    }

    public void updateWeightInSet(String exerciseId, int index, int change){
        activeWorkout.updateWeightInSet(exerciseId, index, change);
    }

    public void endActiveWorkout(){
        activeWorkout.setCurrentTime(activeWorkoutSession.getCurrentDate());
        completedWorkouts.add(activeWorkout);
        activeWorkout = null; //How to remove the pointer? Maybe null is bad? /Valdemar
    }
}