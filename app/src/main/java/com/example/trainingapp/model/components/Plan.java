package com.example.trainingapp.model.components;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;


/**
 * A class for building a workoutplan that contains zero or more workouts.
 *
 * @author ...
 */
public class Plan {

    /**
     * Variable for holding the plan name
     */
    private String planName; // Make sure not able to send null values from GUI

    private LinkedHashMap<String, Workout> workoutMap = new LinkedHashMap<>();

    private final String planId;

    /**
     * Class constructor setting planName
     */
    public Plan() {
        this.planName = "New plan";
        this.planId = UUID.randomUUID().toString();
    }

    public Plan(Plan plan) {
        this.planName = plan.getPlanName();
        this.planId = plan.getId();
        this.workoutMap = plan.getWorkoutMap();
    }
    public Workout getWorkout(String workoutId) {
        return new Workout(workoutMap.get(workoutId));
    }

    public Plan(String name){
        this.planName = name;
        this.planId = UUID.randomUUID().toString();
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanName() {
        return planName;
    }

    public String getId() {
        return planId;
    }

    /**
     * Method for removing a workoutobject from the list of workouts
     *
     * @param workoutId
     */
    public void removeWorkout(String workoutId) {
        workoutMap.remove(workoutId);
    }

    /**
     * Method for getting the list Workouts that Plan contains
     * @return The list of Workouts that Plan contains
     */
    public List<Workout> getWorkoutList(){
        List<Workout> workouts = new ArrayList<>();
        for(String key: workoutMap.keySet()){
            workouts.add(workoutMap.get(key));
        }
        return workouts;

    }

    private LinkedHashMap<String, Workout> getWorkoutMap(){
        //defensive copying?
        return new LinkedHashMap<>(workoutMap);
    }


    /**
     * Method for adding a workoutobject to the list of workouts
     *
     * @param workout workoutobject to add to list
     */
    public void addWorkout(Workout workout) {
        workoutMap.put(workout.getId(), workout);
    }
    @Override

    public String toString() {
        return planName;
    }

    public void setWorkoutName(String name, String workoutId){
        workoutMap.get(workoutId).setName(name);
    }

    public void addExerciseToWorkout(Exercise exercise, String workoutId){
        workoutMap.get(workoutId).addExercise(exercise);
    }

    public void removeExerciseFromWorkout(String workoutId, String exerciseId){
        workoutMap.get(workoutId).removeExercise(exerciseId);
    }

    public void updateExerciseName(String newExerciseName, String workoutId, String exerciseId){
        workoutMap.get(workoutId).updateExerciseName(newExerciseName, exerciseId);
    }

    public void updateExerciseRep(String workoutId, String exerciseId, int reps){
        workoutMap.get(workoutId).updateExerciseRep(exerciseId, reps);
    }

    public void updateExerciseSets(String workoutId, String exerciseId, int sets){
        workoutMap.get(workoutId).updateExerciseSets(exerciseId, sets);
    }
}