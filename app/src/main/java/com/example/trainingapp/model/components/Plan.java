package com.example.trainingapp.model.components;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


/**
 * A class for building a workout plan that contains zero or more workouts.
 *
 * @author ...
 */
public class Plan {

    /**
     * Variable for holding the plan name
     */
    private String planName; // Make sure not able to send null values from GUI

    /**
     * LinkedHashMap for the workouts in the plan
     */
    private LinkedHashMap<String, Workout> workoutMap = new LinkedHashMap<>();

    /**
     * Variable for holding the plan Id
     */
    private final String planId;

    /**
     * Class constructor setting default plan name and generating planId
     */
    public Plan() {
        this.planName = "New plan";
        this.planId = UUID.randomUUID().toString();
    }

    /**
     * Class constructor used for defensive copying
     */
    public Plan(Plan plan) {
        this.planName = plan.getPlanName();
        this.planId = plan.getId();
        this.workoutMap = plan.getWorkoutMap();
    }

    /**
     * Method for getting a workout from the workoutMap
     *
     * @param workoutId the Id for the workout
     *
     * @return the specified workout object
     */
    public Workout getWorkout(String workoutId) throws NullPointerException{
        return new Workout(getWorkoutFromMap(workoutId));
    }

    /**
     * Class constructor setting specified planName and generated planId
     */
    public Plan(String name){
        this.planName = name;
        this.planId = UUID.randomUUID().toString();
    }

    /**
     * Method for setting a new plan name
     *
     * @param planName the new plan name
     */
    public void setPlanName(String planName) {
        this.planName = planName;
    }

    /**
     * Method for getting a plan name
     *
     * @return the plan name
     */
    public String getPlanName() {
        return planName;
    }

    /**
     * Method for getting a plan Id
     *
     * @return the plan Id
     */
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
     * Method for getting the list Workouts that Plan contains, copying the LinkedHashMap to a list
     * @return The list of Workouts that Plan contains
     */
    public List<Workout> getWorkoutList(){
        List<Workout> workouts = new ArrayList<>();
        for(String key: workoutMap.keySet()){
            workouts.add(workoutMap.get(key));
        }
        return workouts;

    }

    /**
     * Method for getting a copy of workoutMap
     *
     * @return copy of the workoutMap
     */
    private LinkedHashMap<String, Workout> getWorkoutMap(){
        //defensive copying?
        return new LinkedHashMap<>(workoutMap);
    }


    /**
     * Method for adding a workout object to the map of workouts
     *
     * @param workout workout object to add to map
     */
    public void addWorkout(Workout workout) {
        workoutMap.put(workout.getId(), workout);
    }

    /**
     * Method for getting plan name
     *
     * @return the plan name
     */
    @NonNull
    @Override
    public String toString() {
        return planName;
    }

    private Workout getWorkoutFromMap(String workoutId) throws NullPointerException{
        return Objects.requireNonNull(workoutMap.get(workoutId), "No workout with this Id exist");
    }

    /**
     * Method for setting a new workout name
     *
     * @param name the new name for the workout
     * @param workoutId the id for the workout
     */
    public void setWorkoutName(String name, String workoutId){
        getWorkoutFromMap(workoutId).setName(name);
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param exercise the exercise to be added
     * @param workoutId the id for the workout
     */
    public void addExerciseToWorkout(Exercise exercise, String workoutId){
        getWorkoutFromMap(workoutId).addExercise(exercise);
    }

    /**
     * Method for removing an exercise from a workout
     *
     * @param workoutId the id for the workout
     * @param exerciseId the id for the exercise
     */
    public void removeExerciseFromWorkout(String workoutId, String exerciseId){
        getWorkoutFromMap(workoutId).removeExercise(exerciseId);
    }

    /**
     * Method for updating the exercise name in a workout
     *
     * @param newExerciseName the new name for the exercise
     * @param workoutId the id for the workout
     * @param exerciseId the id for the exercise
     */
    public void updateExerciseName(String newExerciseName, String workoutId, String exerciseId){
        getWorkoutFromMap(workoutId).updateExerciseName(newExerciseName, exerciseId);
    }

    /**
     * Method for updating the exercise's reps in a workout
     *
     * @param workoutId the id for the workout
     * @param exerciseId the id for the exercise
     * @param reps the new value for the reps
     */
    public void updateExerciseRep(String workoutId, String exerciseId, int reps){
        getWorkoutFromMap(workoutId).updateExerciseRep(exerciseId, reps);
    }

    /**
     * Method for updating the exercise's sets
     *
     * @param workoutId the id for the workout
     * @param exerciseId the id for the exercise
     * @param sets the new value for the sets
     */
    public void updateExerciseSets(String workoutId, String exerciseId, int sets){
        getWorkoutFromMap(workoutId).updateExerciseSets(exerciseId, sets);
    }
}