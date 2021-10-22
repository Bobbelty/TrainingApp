package com.example.trainingapp.mockDatabase;

import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.Workout;

import java.util.List;

/**
 * Interface for the databased used in the application.
 */
public interface IDatabase {

    /**
     * Method for getting a plan list
     */
    List<Plan> getPlanList() throws NullPointerException;

    /**
     * Method for getting completed workouts
     */
    List<ActiveWorkout> getCompletedWorkouts();

    /**
     * Method for adding a plan to the planMap
     */
    void addPlan(Plan newPlan);

    /**
     * Method for removing a plan from the planMap
     */
    void removePlan(String planId);

    /**
     * Method for adding an finished active workout to completed workouts
     *
     * @param workout the workout object to be added
     */
    void addToCompletedWorkouts(ActiveWorkout workout);

    /**
     * Method for updating the plan name
     *
     * @param name the new name of the plan
     * @param Id the Id of the plan
     */
    void updatePlanName(String name, String Id) throws NullPointerException;

    /**
     * Method for removing a workout from a plan
     *
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    void removeWorkoutFromPlan(String planId, String workoutId) throws NullPointerException;

    /**
     * Method for adding a workout to a plan
     *
     * @param workout the workout object to be added
     * @param planId the Id for the plan
     */
    void addWorkoutToPlan(Workout workout, String planId) throws NullPointerException;

    /**
     * Method for updating a workout name in a plan
     *
     * @param name the new name for a workout
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    void updateWorkoutName(String name, String planId, String workoutId) throws NullPointerException;

    /**
     * Method for adding an exercise to a workout
     *
     * @param exercise the exercise object to be added
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    void addExerciseToWorkout(Exercise exercise, String planId, String workoutId) throws NullPointerException;

    /**
     * Method for removing an exercise from a workout
     *
     * @param exerciseName the name of the exercise
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    void removeExerciseFromWorkout(String exerciseName, String planId, String workoutId) throws NullPointerException;

    /**
     * Method for updating an exercise name
     *
     * @param exerciseName the new name for the exercise
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     * @param exerciseId the Id for the exercise
     */
    void updateExerciseName(String exerciseName, String planId, String workoutId, String exerciseId) throws NullPointerException;

    /**
     * Method for updating a rep in an exercise set
     *
     * @param reps the new number of reps
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     * @param exerciseId the Id for the exercise
     */
    void updateExerciseRep(int reps, String planId, String workoutId, String exerciseId) throws NullPointerException;

    /**
     * Method for converting a workout to an active workout
     *
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    void newActiveWorkout(String planId, String workoutId) throws NullPointerException;

    /**
     * Method for updating a rep in an active exercise
     *
     * @param reps the new amount of reps
     * @param exerciseId the Id for the exercise
     */
    void updateActiveExerciseRep(int reps, String exerciseId);

    void endActiveWorkout();

    /**
     * Method for getting a plan
     *
     * @param planId the Id for the plan
     */
    Plan getPlan(String planId) throws NullPointerException;

    /**
     * Method for getting a workout
     *
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     */
    Workout getWorkout(String planId, String workoutId) throws NullPointerException;
    
    ActiveWorkout getActiveWorkout();

    /**
     * Method for updating sets for an exercise
     *
     * @param sets the new amount of sets
     * @param planId the Id for the plan
     * @param workoutId the Id for the workout
     * @param exerciseId the Id for the exercise
     */
    void updateExerciseSets(int sets, String planId, String workoutId, String exerciseId) throws NullPointerException;

    void updateActiveExerciseWeight(String exerciseId, double weight);
}