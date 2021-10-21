package com.example.trainingapp.model;

import com.example.trainingapp.mockDataBase.IDatabase;
import com.example.trainingapp.mockDataBase.MockDataBase;
import com.example.trainingapp.model.activeComponents.ActiveWorkout;
import com.example.trainingapp.model.activeComponents.ActiveWorkoutSession;
import com.example.trainingapp.model.components.Exercise;
import com.example.trainingapp.model.components.Plan;
import com.example.trainingapp.model.components.PlanBuilder;
import com.example.trainingapp.model.components.Workout;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The User-class act as a datahandler that connects all of the model with the modelfacade and the
 * database.
 */
public class TrainingAppFacade {

    /**
     * ActiveWorkoutSession-object to access logic for ActiveWorkout and ActiveExercise.
     */
    private final ActiveWorkoutSession activeWorkoutSession = new ActiveWorkoutSession();

    /**
     * ExerciseIdHandler-object for creating new exerciseId:s
     */
    private final ExerciseIdHandler exerciseIdHandler = new ExerciseIdHandler();

    /**
     * PlanBuilder-object for creating new plancomponents.
     */
    private final PlanBuilder planBuilder = new PlanBuilder();

    /**
     * The facade uses a MockDatabase to store plans, workouts and exercises
     * during runtime. It also stores completed workouts.
     */
    private final IDatabase mockDataBase;

    /**
     * Class constructor initiating the database
     *
     * @param mockDataBase the programs database
     */
    public TrainingAppFacade(IDatabase mockDataBase) {
        this.mockDataBase = mockDataBase;
    }

    /**
     * Method for returning a copy of the list of saved plans from the database
     *
     * @return list of saved plans from database
     */
    public List<Plan> getSavedPlans(){
            return mockDataBase.getPlanList();
    }

    public Plan getPlan(String planId) {
        return mockDataBase.getPlan(planId);
    }

    /**
     * Method for receiving the copy of the list with completed workouts from the database.
     *
     * @return the list of completed workouts.
     */
    public List<ActiveWorkout> getCompletedWorkouts() {return mockDataBase.getCompletedWorkouts();}

    /**
     * Method for removing a specific plan from the database.
     */
    public void removePlan(String planId) {
        mockDataBase.removePlan(planId);
    }
    /**
     * Adds a new Plan-object to the database
     */
    public void createNewPlan(){
        mockDataBase.addPlan(planBuilder.createNewPlan());
    }

    /**
     * Updates a specific plans name
     *
     * @param name the new name
     * @param id the id of the desired plan
     */
    public void updatePlanName(String name, String id){
        mockDataBase.updatePlanName(name, id);
    }

    /**
     * Method for adding a workout to a plan
     *
     * @param planId what plan to add it into
     */
    public void addWorkoutToPlan(String planId){
        mockDataBase.addWorkoutToPlan(planBuilder.createNewWorkout(), planId);
    }

    /**
     * Method for removing a workout from a plan
     *
     * @param planId in which plan
     * @param workoutId which workout to remove
     */
    public void removeWorkoutFromPlan(String planId, String workoutId) {
        mockDataBase.removeWorkoutFromPlan(planId, workoutId);
    }

    /**
     * Updates the name of a specific workout
     *
     * @param name the new name
     * @param planId in which plan
     * @param workoutId which workout to update
     */
    public void updateWorkoutName(String name, String planId, String workoutId){
        mockDataBase.updateWorkoutName(name, planId, workoutId);
    }

    /**
     * Method for adding an exercise to a workout
     *
     * @param planId in which plan
     * @param workoutId in which workout
     */
    public void addExerciseToWorkout(String planId, String workoutId) {
        mockDataBase.addExerciseToWorkout(planBuilder.createNewExercise(), planId, workoutId);
    }

    /**
     * Method for removing an exercise from a workout
     *
     * @param planId in which plan
     * @param workoutId in which workout
     * @param exerciseId which exercise to remove
     */
    public void removeExerciseFromWorkout(String planId, String workoutId, String exerciseId){
        mockDataBase.removeExerciseFromWorkout(planId, workoutId, exerciseId);
    }

    /**
     * Method for updating the name of an exercise
     *
     * @param exerciseName the new name
     * @param planId in which plan
     * @param workoutId in which workout
     * @param exerciseId what exercise to update
     */
    public void updateExerciseName(String exerciseName, String planId, String workoutId, String exerciseId){
        mockDataBase.updateExerciseName(exerciseName, planId, workoutId, exerciseId);
    }

    public void updateExerciseRep(int reps, String planId, String workoutId, String exerciseId){
        mockDataBase.updateExerciseRep(reps, planId, workoutId, exerciseId);
    }

    public void updateExerciseSets(int sets, String planId, String workoutId, String exerciseId){

    }

    public void convertWorkoutToActive(String planId, String workoutId){
        mockDataBase.newActiveWorkout(planId, workoutId);
    }

    public void addSetToActiveExercise(String exerciseId){
        mockDataBase.addNewSet(exerciseId);
    }

    public void removeSetFromExercise(String exerciseId, int index){
        mockDataBase.removeSetFromActiveExercise(exerciseId, index);
    }

    public void updateActiveExerciseRep(int reps, String exerciseId, int index){
        mockDataBase.updateActiveExerciseRep(reps, exerciseId, index);
    }

    public void updateWeightInSet(String exerciseId, int index, int change){
        mockDataBase.updateWeightInSet(exerciseId, index, change);
    }

    public void endActiveWorkout(){
        mockDataBase.endActiveWorkout();
    }
}
