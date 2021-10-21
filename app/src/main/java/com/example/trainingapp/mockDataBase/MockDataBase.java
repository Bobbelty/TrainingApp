package com.example.trainingapp.mockDataBase;

import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.ExerciseIdNotFoundException;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MockDataBase implements IDatabase {

    private final ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();

    private ActiveWorkout activeWorkout;

    private final HashMap<String, Plan> planMap = new HashMap<>();

    private final List<ActiveWorkout> completedWorkouts = new ArrayList<>();

    /*It's possible to iterate through a hashMap, so this HashMap can be used for both
    storing savedExercises and getting the savedExercises for display purposes.*/

    HashMap<String, Integer> ExerciseIdMap = new HashMap<>();
    HashMap<Integer, Integer> currentPBs = new HashMap<>();


    public MockDataBase(){

        Plan examplePlan1 = new Plan("Summer");
        Workout exampleWorkout1 = new Workout("Chest and shoulders");
        Workout exampleWorkout2 = new Workout("Back");

        //addExerciseIdToMap("Bench Press", 123);
        //addExerciseIdToMap("New exercise", 000);
        Exercise exampleExercise0 = new Exercise("Dips");
        Exercise exampleExercise1 = new Exercise("Bench Press");
        Exercise exampleExercise2 = new Exercise("Military Press");

        Workout exampleWorkout5 = new Workout("Legs");
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

        examplePlan1 = new Plan("Winter");
        exampleWorkout2 = new Workout("Breast and shoulders");
        exampleExercise3 = new Exercise("Bench Press");
        exampleExercise4 = new Exercise("Military Press");

        exampleWorkout1 = new Workout("Legs");
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

    //TODO fix defensive copy constructor
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
        completedWorkouts.add(activeWorkout);
        activeWorkout = null; //How to remove the pointer? Maybe null is bad? /Valdemar
    }
}